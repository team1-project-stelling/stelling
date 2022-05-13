package com.team1.stelling.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/inquiry/*")
public class InquiryController {
    @GetMapping("/inquiryDetail")
    public String detailInquiry(){
        return "inquiry/inquiryDetail";
    }

    @GetMapping("/inquiryWrite")
    public String writeInquiry(){
        return "inquiry/inquiryWrite";
    }

}
