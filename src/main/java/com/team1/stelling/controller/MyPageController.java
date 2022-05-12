package com.team1.stelling.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/myPage/*")
public class MyPageController {

/*    @RequestMapping("")
    public void changPw(){log.info("changePw");}*/

    @GetMapping("/myWork")
    public String myWork2(){
        log.info("myWork");
        return "myPage/myPageMyWork";
    }

    @GetMapping("/myWork2")
    public String myWork3(){
        log.info("myWork2");
        return "myPage/myPageMyWork2";
    }

    @GetMapping("/editProfile")
    public String editProfile(){
        log.info("editProfile");
        return "myPage/myPageEditProfile";
    }
    @GetMapping("/myPageQuestion")
    public String myPageQuestion(){
        log.info("myPageQuestion");
        return "myPage/myPageQuestion";
    }
    @GetMapping("/myPagePayList")
    public String myPagePayList(){
        log.info("myPagePayList");
        return "myPage/myPagePayList";
    }



}
