package com.team1.stelling.controller;

import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.domain.vo.UserVO;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@RequiredArgsConstructor
@RequestMapping("/myPage/*")
public class MyPageController {
    private final UserService userService;


    //프로필수정
    @PostMapping("/myPageEditProfile")
    public void modify(UserVO userVO, Model model){
//        HttpSession session = req.getSession();
//        Long userNum = (Long) session.getAttribute("userNumber");
        UserVO sessionUser = userService.get(userVO.getUserNumber());
        sessionUser.updateFilePate(userVO.getUserFilePath());
        sessionUser.updateFileName(userVO.getUserFileName());
        sessionUser.updateUserUuid(userVO.getUserUuid());
        sessionUser.updateUserEmail(userVO.getUserEmail());
        sessionUser.updateUserNickName(userVO.getUserNickName());
        sessionUser.updateUserPhoneNum(userVO.getUserPhoneNum());
        log.info(userVO.toString());
        userService.modify(sessionUser);
        model.addAttribute("userVO", sessionUser);
    }

    @GetMapping("/myPageEditProfile")
    public String myPageEditProfile(Model model,Long userNumber){

        log.info("" + userNumber);
        UserVO sessionUser = userService.get(userNumber);
        log.info("myPageEditProfile");
        model.addAttribute("userVO", sessionUser);
        return "/myPage/myPageEditProfile";
    }
    //---------

    @GetMapping("/myPageMyWork")
    public void myWork(){
        log.info("myWork");
    }


    @GetMapping("/myPageChangePw")
    public void myPageChangePw() {
        log.info("myPageChangePw");
    }



    @GetMapping("/myPageQuestion")
    public String myPageQuestion(){
        log.info("myPageQuestion");
        return "myPage/myPageQuestion";
    }

    //탈퇴(status 1->0으로 변경)
    @GetMapping("/withDraw")
    public String withDraw(){
        UserVO sessionUser = userService.get(28L);
        sessionUser.updateUserStatus(0L);
        userService.modify(sessionUser);
        return "main/index";
    }
    @GetMapping("/myPageQuit")
    public void myPageQuit(){
        log.info("myPageQuit");
    }
    //------------

    @GetMapping("/myPagePayList")
    public String myPagePayList(){
        log.info("myPagePayList");
        return "myPage/myPagePayList";
    }


    //파일 업로드
    @PostMapping("/uploadAjaxAction")
    @ResponseBody //비동기를 처리하는 경우
    public List<UserVO> uploadAjaxPost(MultipartFile[] uploadFile) {
        String uploadFolder = "C:/stelling";
        List<UserVO> fileList = new ArrayList<>();
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

            UserVO userVO = new UserVO();

            uploadFileName = uuid.toString() + "_" + file.getOriginalFilename();

            userVO.setUserFileName(uploadFileName);
            userVO.setUserUuid(uuid.toString());
            userVO.setUserFilePath(uploadFolderPath);

            //저장할 경로와 파일의 이름을 File객체에 담는다.
            File saveFile = new File(uploadPath, uploadFileName);

            try {
                //설정한 경로에 해당 파일을 업로드한다.
                file.transferTo(saveFile);
//                InputStream in = new FileInputStream(saveFile);


                fileList.add(userVO);
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



}