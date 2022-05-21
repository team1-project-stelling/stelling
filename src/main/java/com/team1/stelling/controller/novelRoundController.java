package com.team1.stelling.controller;

import com.team1.stelling.domain.repository.NovelRepository;
import com.team1.stelling.domain.repository.SubNovelRepository;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.domain.vo.SubNovelVO;
import com.team1.stelling.service.NovelService;
import com.team1.stelling.service.SubNovelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.rule.Mode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/novel/*")
@RequiredArgsConstructor
public class novelRoundController {
    private final SubNovelService subNovelService;
    private final NovelService novelService;

    @GetMapping("/novelRoundInfo")
    @ResponseBody
    public byte[] getFile(Long novelNumber) throws IOException{
        NovelVO novelVO = novelService.get(novelNumber);
//        NovelVO novelVO = novelRepository.findById(novelNumber).get();
        return FileCopyUtils.copyToByteArray(new File("C:/stelling/" +novelVO.getNovelUploadPath()+"/"+novelVO.getNovelFileName()));
    }

    @GetMapping("/getNovelVO/{novelNumber}")
    @ResponseBody
    public NovelVO getNovelVO(@PathVariable("novelNumber") Long novelNumber){
        NovelVO novelVO = novelService.get(novelNumber);
        return novelVO;
    }



    @GetMapping("/getSubNovelList")
    @ResponseBody
    public  List<SubNovelVO> getSubNovel(Long novelNumber){
        List<SubNovelVO> sub = subNovelService.getList(novelNumber);
        return sub;
    }

    @GetMapping("/orderBySubNovelList")
    @ResponseBody
    public List<SubNovelVO> orderBySubNovelList(Long novelNumber){
        List<SubNovelVO> sub = subNovelService.orderBySubNovelList(novelNumber);
        log.info("_----------------------------------------------------------------");
        log.info(sub.toString());
        log.info("_----------------------------------------------------------------");
        return sub;

        }

}
