package com.team1.stelling.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/mypage/*")
public class ExampleController2 {

    @RequestMapping("")
    public void changPw(){log.info("changePw");}

    @GetMapping("/myWork2")
    public String myWork2(){
        log.info("myWork2");
        return "myPage_myWork";
    }

    @GetMapping("/myWork3")
    public String myWork3(){
        log.info("myWork3");
        return "myPage_myWork2";
    }

    @GetMapping("/editProfile")
    public String editProfile(){
        log.info("editProfile");
        return "myPage_editProfile";
    }

    @GetMapping("/detailInquiry")
    public String detailInquiry(){
        return "inquiry_detail";
    }

    @GetMapping("/writeInquiry")
    public String writeInquiry(){
        return "inquiry_write";
    }

    @GetMapping("/ranking")
    public String ranking(){
        return "ranking/ranking";
    }
}
