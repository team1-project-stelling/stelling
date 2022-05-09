package com.team1.stelling.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/myLibaray/*")
public class ExampleController {

    @RequestMapping("")
    public void myLibrary(){
        log.info("libaray");
    }
}
