package com.team1.stelling.controller;

import com.team1.stelling.domain.vo.UserVO;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/myPage/*")
public class MyPageController {
    private final UserService userService;

    @PostMapping("/myPageEditProfile")
    public void modify(UserVO userVO, Model model){
        UserVO sessionUser = userService.get(2L);
        sessionUser.updateUserEmail(userVO.getUserEmail());
        sessionUser.updateUserNickName(userVO.getUserNickName());
        sessionUser.updateUserPhoneNum(userVO.getUserPhoneNum());
        userService.modify(sessionUser);
        model.addAttribute("userVO", sessionUser);
    }

    @GetMapping("/myPageEditProfile")
    public String myPageEditProfile(Model model){
        UserVO sessionUser = userService.get(2L);
        log.info("myPageEditProfile");
        model.addAttribute("userVO", sessionUser);
        return "/myPage/myPageEditProfile";
    }

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

    @GetMapping("/myPageQuit")
    public String myPageQuit(){
        log.info("myPageQuit");
        return "myPage/myPageQuit";
    }

    @GetMapping("/myPagePayList")
    public String myPagePayList(){
        log.info("myPagePayList");
        return "myPage/myPagePayList";
    }



}