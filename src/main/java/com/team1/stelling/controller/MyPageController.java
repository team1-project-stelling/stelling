package com.team1.stelling.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/myPage/*")
public class MyPageController {


    @GetMapping("/myPageEditProfile")
    public String editProfile(){
        log.info("editProfile");
        return "myPage/myPageEditProfile";
    }

    @GetMapping("/myPageMyWork")
    public void myWork(){
        log.info("myWork");
    }

    @GetMapping("/myPageChangePw")
    public void myPageChangePw(){
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