package com.team1.stelling.controller;


import com.team1.stelling.aspect.annotation.LogStatus;
import com.team1.stelling.domain.repository.NovelRepository;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.service.NovelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/novel/*")
@RequiredArgsConstructor
public class novelController {

    private  final NovelRepository novelRepository;


    @GetMapping("/novelRegister")
    public void ViewDetail(){
    }
    @GetMapping("/novelWrite")
    public void novelWrite(){
    }
    @LogStatus
    @GetMapping("/novelCategory")
    public void novelCategory(Model model){
    }
    @GetMapping("/novelRanking")
    public void novelRanking(){
    }
    @GetMapping("/novelRoundList")
    public void novelRoundList(){
    }
    @GetMapping("/novelDetailView")
    public void novelDetailView(){
    }

    @PostMapping("/novelRegister")
    public void novelRegister(NovelVO novelVO){
        log.info("=============================================");
        log.info(novelVO.toString());
        log.info("=============================================");
        novelRepository.save(novelVO);

    }



}
