package com.team1.stelling.controller;


import com.team1.stelling.aspect.annotation.LogStatus;
import com.team1.stelling.domain.dto.NovelCategoryDTO;
//import com.team1.stelling.domain.repository.NovelSearchRepository;
import com.team1.stelling.domain.dto.PageableDTO;
import com.team1.stelling.service.NovelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/novel/*")
@RequiredArgsConstructor
public class novelController {

    private  final NovelService novelService;
//    private  final NovelSearchService novelSearchService;


    @GetMapping("/novelRegister")
    public void ViewDetail(){
    }

    @GetMapping("/novelWrite")
    public void novelWrite(){
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



}
