package com.team1.stelling.controller;

import com.team1.stelling.domain.repository.NovelRepository;
import com.team1.stelling.domain.vo.NovelVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
@Slf4j
@RequestMapping("/novel/*")
@RequiredArgsConstructor
public class novelRoundController {

    private final NovelRepository novelRepository;

    @GetMapping("/novelRoundInfo")
    @ResponseBody
    public byte[] getFile(Long novelNumber) throws IOException{
        NovelVO novelVO = novelRepository.findById(novelNumber).get();
        return FileCopyUtils.copyToByteArray(new File("C:/stelling/" +novelVO.getNovelUploadPath()+"/"+novelVO.getNovelFileName()));
    }

    @GetMapping("/getNovelVO/{novelNumber}")
    @ResponseBody
    public NovelVO getNovelVO(@PathVariable("novelNumber") Long novelNumber){
        NovelVO novelVO = novelRepository.findById(novelNumber).get();
        return novelVO;
    }

}
