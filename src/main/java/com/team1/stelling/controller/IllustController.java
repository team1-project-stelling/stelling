package com.team1.stelling.controller;


import com.team1.stelling.aspect.annotation.LogStatus;
import com.team1.stelling.domain.dto.IllustProfileDTO;
import com.team1.stelling.domain.dto.PageableDTO;
import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.IllustVO;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.domain.vo.UserVO;
import com.team1.stelling.service.IllustProfileService;
import com.team1.stelling.service.IllustService;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/illust/*")
@RequiredArgsConstructor
public class IllustController {

    private final IllustProfileService illustProfileService;
    private final IllustService illustService;
    private final UserService userService;

    @LogStatus
    @GetMapping("/illustList")
    public void illustList(Long illustNumber, Model model, @PageableDefault(page = 0, size = 10, sort = "illustNumber" ,direction = Sort.Direction.DESC)Pageable pageable){

        List<IllustProfileDTO> profile = illustProfileService.list();
        Page<IllustVO> list = illustService.getList(pageable);
        PageableDTO pageableDTO = new PageableDTO((int) list.getTotalElements(), pageable);

        model.addAttribute("illustNumber", illustNumber);
        model.addAttribute("profile", profile);
        model.addAttribute("list", list);
        model.addAttribute("pageableDTO", pageableDTO);
    }

    @GetMapping("/illustList/viewCount")
    public String illustListViewCount(Long illustNumber, Model model, @PageableDefault(page = 0, size = 10, sort = "illustViewCount" ,direction = Sort.Direction.DESC)Pageable pageable){

        List<IllustProfileDTO> profile = illustProfileService.list();
        Page<IllustVO> list = illustService.getList(pageable);
        PageableDTO pageableDTO = new PageableDTO((int) list.getTotalElements(), pageable);

        model.addAttribute("illustNumber", illustNumber);
        model.addAttribute("profile", profile);
        model.addAttribute("list", list);
        model.addAttribute("pageableDTO", pageableDTO);

        return "illust/illustListViewCount";
    }

    @GetMapping("/illustList/like")
    public String illustListLike(Long illustNumber, Model model, @PageableDefault(page = 0, size = 10, sort = "illustLike" ,direction = Sort.Direction.DESC)Pageable pageable){

        List<IllustProfileDTO> profile = illustProfileService.list();
        Page<IllustVO> list = illustService.getList(pageable);
        PageableDTO pageableDTO = new PageableDTO((int) list.getTotalElements(), pageable);

        model.addAttribute("illustNumber", illustNumber);
        model.addAttribute("profile", profile);
        model.addAttribute("list", list);
        model.addAttribute("pageableDTO", pageableDTO);

        return "illust/illustListLike";
    }

    @GetMapping("/illustChatPage")
    public void chatForm(){
    }

    @GetMapping("/illustCategoryList")
    public String illustCategoryList(Long illustNumber, String keyword, Model model, @PageableDefault(page = 0, size = 10, sort = "illustNumber" ,direction = Sort.Direction.DESC)Pageable pageable){
        Page<IllustVO> list = illustService.CategoryList(keyword, pageable);
        PageableDTO pageableDTO = new PageableDTO( (int)list.getTotalElements(),pageable);

        model.addAttribute("illustNumber", illustNumber);
        model.addAttribute("list", list);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageableDTO", pageableDTO);

        return "illust/illustCategoryList";
    }


    /*이미지 저장*/
    @PostMapping("/uploadAjaxAction")
    @ResponseBody
    public List<IllustVO> uploadAjaxPost(MultipartFile[] uploadFile) {
        String uploadFolder = "C:/stelling";
        List<IllustVO> fileList = new ArrayList<>();

        UUID uuid = UUID.randomUUID();
        String uploadFileName = null;

        String uploadFolderPath = getPath();
        File uploadPath = new File(uploadFolder, uploadFolderPath);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        for (MultipartFile file : uploadFile) {

            uploadFileName = uuid.toString() + "_" + file.getOriginalFilename();
            File saveFile = new File(uploadPath, uploadFileName);

            try {

                file.transferTo(saveFile);
                fileList.add(IllustVO.builder().illustFileName(uploadFileName).illustUuid(uuid.toString()).illustFilePath(uploadFolderPath).build());

            } catch (IOException e) {;}

        }

        log.info("------------------------------------");
        log.info(fileList.toString());
        log.info(uploadFolder);
        log.info(uploadPath.toString());
        log.info(uuid.toString());
        log.info(uploadFileName);
        log.info("------------------------------------");
        return fileList;




    }

    @GetMapping("/illustPostingPage") public void illustRegister(){}

    @PostMapping("/illustPostingPage")
    public void illustRegister(IllustVO illustVO,HttpServletRequest request){

        HttpSession session = request.getSession();
        Long userNumber = Long.valueOf((Integer)session.getAttribute("userNumber"));
        illustVO.setUserVO(userService.get(userNumber));
        illustService.illustRegister(illustVO);

    }

    /*파일저장경로(당일 날짜로)*/
    private String getPath() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        return sdf.format(today);
    }

    //저장된 이미지 가져오기
    @GetMapping("/illustImg")
    @ResponseBody
    public byte[] getFile(@RequestParam("illustNumber") Long illustNumber) throws IOException{
        IllustVO illustVO = illustService.get(illustNumber);
        return FileCopyUtils.copyToByteArray(new File("C:/stelling/" +illustVO.getIllustFilePath()+"/"+illustVO.getIllustFileName()));

    }

    @GetMapping("/illustUserInput")
    public void illustUserInput(Long userNumber, Model model){

        model.addAttribute("user", userService.get(userNumber));
    }

    @GetMapping("/register") public void register(){}

    @PostMapping("/register")
    public RedirectView register(Long userNumber, IllustProfileVO illustProfileVO, RedirectAttributes rttr){

        illustProfileVO.setUserNumber(userNumber);

        illustProfileService.register(illustProfileVO);

//        rttr.addFlashAttribute("userNumber", illustProfileVO.getUserNumber());

        return new RedirectView("illustList");
    }


    @GetMapping("/illustUserPage")
    public String illustUserPage(Long userNumber, Long illustNumber,  Model model, @PageableDefault(page = 0, size = 10, sort = "illustNumber" ,direction = Sort.Direction.DESC) Pageable pageable){


        Page<IllustVO> list = illustService.getUserIllustList(pageable, userNumber);
        PageableDTO pageableDTO = new PageableDTO((int) list.getTotalElements(), pageable);

        model.addAttribute("illustNumber", illustNumber);
        model.addAttribute("getLikeTotal", illustService.getLikeTotal(userNumber));
        model.addAttribute("illustProfile", illustProfileService.getProfile(userNumber));
        model.addAttribute("total", list.getTotalElements());
        model.addAttribute("pageableDTO", pageableDTO);
        model.addAttribute("list", list);

        return "illust/illustUserPage";
    }

    @LogStatus
    @GetMapping("/illustViewDetail")
    public String read(Long illustNumber, Long userNumber, Model model, @PageableDefault(page = 0, size = 10, sort = "illustNumber" ,direction = Sort.Direction.DESC) Pageable pageable){

        List<IllustVO> list = illustService.getSixList(userNumber);

        illustService.updateViewCOunt(illustNumber);

        model.addAttribute("illustNumber", illustNumber);
        model.addAttribute("illust", illustService.get(illustNumber));
        model.addAttribute("total", list.size());
        model.addAttribute("list", list);

        return "illust/illustViewDetail";
    }




//    @GetMapping("/uploadTest")
//    public String readFile() {
//        return "upload/uploadTest";
//    }


/*
    @PostMapping("/uploadTest")
    public String uploadTest(@RequestParam("file") MultipartFile mfile, Model model) throws IOException, TikaException, SAXException {
        log.info("========file들어옴======");
*/
/*        try{
            InputStream fileStream  =  mfile.getInputStream();

        //버퍼 선언
        byte[] readBuffer = new byte[fileStream.available()];
        while (fileStream.read( readBuffer ) != -1){}
        log.info(new String(readBuffer)); //출력

        fileStream.close(); //스트림 닫기
    } catch (Exception e) {
       log.info(e.getMessage());
    }*//*


        String result = null;
        BodyContentHandler handler = new BodyContentHandler();
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        InputStream fileStream  =  mfile.getInputStream();
        try (InputStream stream = fileStream)
        {
        parser.parse(stream, handler, metadata);
//        log.info(handler.toString());
        result =handler.toString();
        }


        return result;
    }
*/



}
