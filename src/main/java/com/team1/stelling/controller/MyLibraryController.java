package com.team1.stelling.controller;

import com.team1.stelling.service.PayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/myLibrary/*")
@RequiredArgsConstructor
public class MyLibraryController {

    private final PayService payService;

    @RequestMapping("")
    public void myLibrary(){
        log.info("libaray");
    }

    // 소장함 -> 결제
    @GetMapping("/myLibraryCollection")
    public String myBook(){
        log.info("myLibraryCollection");
        return "myLibrary/myLibraryCollection";
    }

    // 최근 본 작품
    @GetMapping("/myLibraryRecentView")
    public String myLibraryRecentView(){
        log.info("myLibraryRecentView");
        return "myLibrary/myLibraryRecentView";
    }
    
    // 찜목록 -> 그냥찜
    @GetMapping("/myLibraryPick")
    public String myLibraryPick(){
        log.info("myLibraryPick");
        return "myLibrary/myLibraryPick";
    }

    @GetMapping("/coinShop")
    public String coinShop(){
        log.info("coinShop");
        return "cash/coinShop";
    }

    @GetMapping("/payList")
    public String payList(Long userNumber, Model model){
        log.info("userNumber List에 담기 전" + String.valueOf(userNumber));
        model.addAttribute("payList", payService.getList(userNumber));
        log.info("userNumber1 List에 담은 후" + String.valueOf(userNumber));
        return "myPage/myPagePayList";
    }
}
