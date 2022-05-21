package com.team1.stelling.controller;

import com.team1.stelling.domain.dto.NovelDetailVIewDTO;
import com.team1.stelling.domain.vo.NovelFileVO;
import com.team1.stelling.domain.vo.SubNovelVO;
import com.team1.stelling.service.NovelFileService;
import com.team1.stelling.service.NovelService;
import com.team1.stelling.service.SubNovelService;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/novelDetail/*")
@RequiredArgsConstructor
public class NovelDetailViewController {

    private  final NovelService novelService;
    private final UserService userService;
    private final SubNovelService subNovelService;
    private final NovelFileService novelFileService;


    @GetMapping("/showNovel/{subNovelNumber}/{novelNumber}")
    @ResponseBody
    public NovelDetailVIewDTO ViewDetail(@PathVariable("subNovelNumber") Long subNovelNumber, @PathVariable("novelNumber") Long novelNumber) throws IOException {
      String getFilePathBySubNum= novelFileService.getFilePathBySubNum(subNovelNumber).getNovelFileFilePath();
      String getFileNameBySubNum= novelFileService.getFilePathBySubNum(subNovelNumber).getNovelFileFileName();
        NovelDetailVIewDTO novelDetailVIewDTO = new NovelDetailVIewDTO();
        SubNovelVO subNovelVO = subNovelService.get(subNovelNumber);
        String writerComment = subNovelVO.getSubNovelWriterComment();
        int likeCount = subNovelVO.getSubNovelLikeCount();
        List<SubNovelVO> subNovelTitleList =subNovelService.orderBySubNovelList(novelNumber);

        BufferedReader br = null;
        String line = null;
        String result = "";
        try {
            br = new BufferedReader(new FileReader("C:/stelling/"+getFilePathBySubNum+"/"+getFileNameBySubNum+".txt"));
            log.info("===================================================================================");

            while((line = br.readLine()) != null){
                result+=line+"\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(br !=null){
                br.close();
            }
        }

        novelDetailVIewDTO.setNovelContent(result);
        novelDetailVIewDTO.setWriterComment(writerComment);
        novelDetailVIewDTO.setLikeCount(likeCount);
        novelDetailVIewDTO.setSubNovelTitleList(subNovelTitleList);
        return novelDetailVIewDTO;
    }

    @GetMapping("/{subNovelNumber}/{num}")
    @ResponseBody
    public int subNovelLikeCount(@PathVariable("subNovelNumber")Long subNovelNumber, @PathVariable("num") int num){
       SubNovelVO subNovelVO = subNovelService.get(subNovelNumber);
       subNovelVO.updateSubNovelLickCount(num);
       subNovelService.register(subNovelVO);
       return subNovelVO.getSubNovelLikeCount();
    }




}