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
        return "mypage/myWork2";
    }

    @GetMapping("/myWork3")
    public String myWork3(){
        log.info("myWork3");
        return "mypage/myWork3";
    }
}
