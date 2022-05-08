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

    @GetMapping("/myBook")
    public String myBook(){
        log.info("myBook");
        return "myLibaray/myBook";
    }

    @GetMapping("/myRead")
    public String myRead(){
        log.info("myRead");
        return "myLibaray/myRead";
    }

    @GetMapping("/coinShop")
    public String coinShop(){
        log.info("coinShop");
        return "/coinShop";
    }
}
