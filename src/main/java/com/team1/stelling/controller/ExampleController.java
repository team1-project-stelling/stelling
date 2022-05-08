package com.team1.stelling.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/myLibaray/*")
public class ExampleController {

    @RequestMapping("")
    public void myLibrary(){
        log.info("libaray");
    }

    @GetMapping("/index")
    public String index(){
        log.info("index");
        return "/index";
    }

    @GetMapping("/round")
    public String round(){
        log.info("round");
        return "/round";
    }
}
