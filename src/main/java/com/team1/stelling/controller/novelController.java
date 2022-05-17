package com.team1.stelling.controller;


import com.team1.stelling.aspect.annotation.LogStatus;
import com.team1.stelling.domain.dto.NovelCategoryDTO;
//import com.team1.stelling.domain.repository.NovelSearchRepository;

import com.team1.stelling.domain.dto.PageableDTO;

import com.team1.stelling.domain.repository.NovelFileRepository;
import com.team1.stelling.domain.repository.NovelRepository;
import com.team1.stelling.domain.repository.SubNovelRepository;
import com.team1.stelling.domain.repository.UserRepository;
import com.team1.stelling.domain.vo.*;
import com.team1.stelling.service.IllustImgFileService;

import com.team1.stelling.service.NovelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@Slf4j
@RequestMapping("/novel/*")
@RequiredArgsConstructor
public class novelController {

    private  final NovelService novelService;
    private final NovelRepository novelRepository;
    private final UserRepository userRepository;
    private final SubNovelRepository subNovelRepository;
    private final NovelFileRepository novelFileRepository;
//    private  final NovelSearchService novelSearchService;


    @GetMapping("/novelRegister")
    public void ViewDetail(){
    }

    @GetMapping("/novelWrite")
    public void novelWrite(){
    }


    @LogStatus
    @GetMapping("/novelCategory")
    public void novelCategory(Model model, @PageableDefault(page = 0, size = 10, sort = "novelNumber" ,direction = Sort.Direction.DESC)Pageable pageable){

       Page<NovelCategoryDTO> list = novelService.getList(pageable);
        PageableDTO pageableDTO = new PageableDTO( (int)list.getTotalElements(),pageable);
        model.addAttribute( "list",list);
        model.addAttribute( "novelTotal", list.getTotalElements());
        model.addAttribute("pageableDTO", pageableDTO);
    }


    @GetMapping("/novelRanking")
    public void novelRanking(){
    }

    @GetMapping("/novelRoundList")
    public void novelRoundList(){
    }

    @GetMapping("/novelDetailView")
    public void novelDetailView(){
    }


    @LogStatus
    @GetMapping("/novelSearch")
    public String novelSearch (String keyword, Model model, @PageableDefault(page = 0, size = 10, sort = "novelNumber" ,direction = Sort.Direction.DESC)Pageable pageable){
        log.info("#############keyword:"+keyword);
        Page<NovelCategoryDTO> searchList = novelService.search(keyword, pageable);
//        Page<NovelCategoryDTO> searchList = novelSearchService.search(keyword, pageable);
        PageableDTO pageableDTO = new PageableDTO( (int)searchList.getTotalElements(),pageable);
        searchList.getSize();
        model.addAttribute("list", searchList);
        model.addAttribute( "novelTotal", searchList.getTotalElements());
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageableDTO", pageableDTO);
        return "novel/novelCategory";
    }

    @PostMapping("/novelRegister")
    public void novelRegister(NovelVO novelVO) {
        log.info("=============================================");
        log.info(novelVO.toString());
        log.info("=============================================");
        novelRepository.save(novelVO);

    }


    @PostMapping("/uploadAjaxAction")
    @ResponseBody
    public List<NovelVO> uploadAjaxPost(MultipartFile[] uploadFile) {
        String uploadFolder = "C:/stelling";
        List<NovelVO> fileList = new ArrayList<>();
//        UUID(Universally unique identifier) : 범용 고유 식별자
//        네트워크 상에서 각각의 개체들을 식별하기 위하여 사용되었다.
//        중복될 가능성이 거의 없다고 인정되기 때문에 많이 사용된다.
//        UUID의 개수는 10의 38승입니다.

        UUID uuid = UUID.randomUUID();
        String uploadFileName = null;

        String uploadFolderPath = getPath();
        File uploadPath = new File(uploadFolder, uploadFolderPath);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        for (MultipartFile file : uploadFile) {
            log.info("-------------------------");
            log.info("Upload File Name : " + file.getOriginalFilename());
            log.info("Upload File Size : " + file.getSize());

            NovelVO novelVO = new NovelVO();
            uploadFileName = uuid.toString() + "_" + file.getOriginalFilename();

            novelVO.setNovelFileName(uploadFileName);
            novelVO.setNovelUUID(uuid.toString());
            novelVO.setNovelUploadPath(uploadFolderPath);

            //저장할 경로와 파일의 이름을 File객체에 담는다.
            File saveFile = new File(uploadPath, uploadFileName);

            try {
                //설정한 경로에 해당 파일을 업로드한다.
                file.transferTo(saveFile);
//                InputStream in = new FileInputStream(saveFile);


                fileList.add(novelVO);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        log.info("----------------------------------------------------------");
        log.info(fileList.toString());
        log.info("----------------------------------------------------------");
        return fileList;
    }


    private String getPath() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        return sdf.format(today);
    }


    /*소설 회차 파일입력 textarea에 뿌려주기*/
    @ResponseBody
    @PostMapping(value = "/novelFileUpload", headers = ("content-type=multipart/*"))
    public String uploadTest(@RequestParam("file") MultipartFile mfile, Model model) throws IOException, TikaException, SAXException {
        String result = null;
        BodyContentHandler handler = new BodyContentHandler();
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        InputStream fileStream = mfile.getInputStream();
        try (InputStream stream = fileStream) {
            parser.parse(stream, handler, metadata);
            result = handler.toString();
        }
        return result;
    }


    /*소설회차 원고파일 생성*/
    @ResponseBody
    @PostMapping("/makeNovelFile")
    public String novelBufferedWrite(NovelFileDTO novelFileDTO) throws IOException {
        log.info("-------------------------------------------------------------------------------------");
        log.info("novelWrite들어옴");
        log.info(novelFileDTO.getContent());
        log.info(novelFileDTO.getSubNovelTitle());
        log.info(novelFileDTO.getUserNumber().toString());
        log.info("-------------------------------------------------------------------------------------");
        NovelVO novelVO = novelRepository.findById(novelFileDTO.getNovelNumber()).get();
        UserVO userVO = userRepository.findById(novelFileDTO.getUserNumber()).get();

        SubNovelVO subNovelVO = new SubNovelVO();
        subNovelVO.setNovelVO(novelVO);
        subNovelVO.setUserVO(userVO);
        subNovelVO.setSubNovelTitle(novelFileDTO.getSubNovelTitle());
        subNovelVO.setSubNovelWriterComment(novelFileDTO.getSubNovelWriterComment());
        subNovelVO.setSubNovelStatus(1); //회차상태 0: 숨김, 1:보여짐
        subNovelRepository.save(subNovelVO);

        String title = novelVO.getNovelTitle();
        String uploadFolder = "C:/stelling";
        UUID uuid = UUID.randomUUID();
        String uploadFolderPath = novelVO.getNovelNumber()+"_"+title+"/"+getPath();
        String uploadFileName = uuid.toString() + "_" + novelFileDTO.getSubNovelTitle();

        File uploadPath = new File(uploadFolder, uploadFolderPath);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        NovelFileVO novelFileVO = new NovelFileVO();
        novelFileVO.setNovelFileFileName(uploadFileName);
        novelFileVO.setNovelFileFilePath(uploadFolderPath);
        novelFileVO.setNovelFileOriginalUUID(uuid.toString());
        novelFileVO.setSubNovelVO(subNovelVO);
        novelFileVO.setNovelVO(novelVO);
        novelFileVO.setUserVO(userVO);
        novelFileRepository.save(novelFileVO);


        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(uploadPath+"/"+uploadFileName+".txt")));
        bw.write(novelFileDTO.getContent());
        bw.close();
        return "파일생성 성공";
    }



}
