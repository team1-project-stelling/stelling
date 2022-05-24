package com.team1.stelling.controller;

import com.team1.stelling.aspect.annotation.LogStatus;
import com.team1.stelling.domain.dto.PageDTO;
import com.team1.stelling.domain.dto.PageableDTO;
import com.team1.stelling.domain.dto.SubNovelDeleteDTO;
import com.team1.stelling.domain.repository.NovelRepository;
import com.team1.stelling.domain.repository.SubNovelRepository;
import com.team1.stelling.domain.vo.*;
import com.team1.stelling.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Controller
@Slf4j
@RequestMapping("/novel/*")
@RequiredArgsConstructor
public class novelRoundController {
    private final SubNovelService subNovelService;
    private final NovelService novelService;
    private final ReplyService replyService;
    private final UserService userService;
    private final MyPickService myPickService;


    //저장된 소설 표지 가져오기
    @GetMapping("/novelRegisterImg")
    @ResponseBody
    public byte[] getFile(@RequestParam("novelNumber") Long novelNumber) throws IOException{
        NovelVO novelVO = novelService.get(novelNumber);
        return FileCopyUtils.copyToByteArray(new File("C:/stelling/" +novelVO.getNovelUploadPath()+"/"+novelVO.getNovelFileName()));
    }
//
//    @GetMapping("/getNovelVO/{novelNumber}")
//    @ResponseBody
//    public NovelVO getNovelVO(@PathVariable("novelNumber") Long novelNumber){
//        NovelVO novelVO = novelService.get(novelNumber);
//        return novelVO;
//    }



    @GetMapping("/novelRoundList")
    public void getSubNovel(Long novelNumber, @PageableDefault(page = 0, size = 10, sort = "subNovelNumber" ,direction = Sort.Direction.ASC) Pageable pageable, Model model){
        NovelVO novelVO = novelService.get(novelNumber);
        Page<SubNovelVO> subNovelVOS = subNovelService.getListByNovelNumber(novelNumber,pageable);
        int listSize = subNovelService.getListByNovelNumber(novelNumber).size();
        String writerName = userService.get(novelVO.getUserVO().getUserNumber()).getUserNickName();
        PageableDTO pageableDTO = new PageableDTO((int)subNovelVOS.getTotalElements(), pageable);

        if(novelService.get(novelNumber).getNovelFileName().contains("sampleImg")){
            String novelImgSrc = "/images/"+novelService.get(novelNumber).getNovelFileName();
            model.addAttribute("novelImgSrc", novelImgSrc);
        }

        ArrayList<Long> sNumbers = new ArrayList<>();
        for (SubNovelVO sub : subNovelVOS){
            sNumbers.add(sub.getSubNovelNumber());
        }


        model.addAttribute("novelNumber", novelNumber);
        model.addAttribute("subnovelVOList",subNovelVOS);
        model.addAttribute("listSize",listSize);
        model.addAttribute("novelVO", novelVO);
        model.addAttribute("pageableDTO", pageableDTO);
        model.addAttribute("writerName", writerName);
        model.addAttribute("firstSNumber",  sNumbers.get(0));

    }

    @PostMapping(value = {"/deleteSubNovel"}, consumes = "application/json")
    @ResponseBody
    public String deleteSubNovel(@RequestBody SubNovelDeleteDTO subNovelDeleteDTO){

        for(Long SubNovelNumber :  subNovelDeleteDTO.getDeleteNumber()){
            subNovelService.removeSubNovelVO(SubNovelNumber);
        }
      return "삭제성공";
    }

    @GetMapping("/myPick")
    @ResponseBody
    public String novelPick(int num, Long novelNumber, Long userNumber){
        if(num==1) {
            myPickService.register(MyPickVO.builder()
                    .novelVO(novelService.get(novelNumber))
                    .userVO(userService.get(userNumber))
                    .build());
            return "찜하기추가";
        }else{
            myPickService.removeMyPick(myPickService.getByNovelNumAndUserNum(novelNumber, userNumber).getMyPickNumber());
            return "찜하기삭제";
        }
    }




}
