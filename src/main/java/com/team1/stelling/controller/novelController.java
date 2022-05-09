package com.team1.stelling.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/novel/*")
public class novelController {
    @GetMapping("/novelRegister")
    public void ViewDetail(){
    }
    @GetMapping("/novelWrite")
    public void novelWrite(){
    }
}
