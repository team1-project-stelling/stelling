package com.team1.stelling.controller;

import com.team1.stelling.domain.vo.ReplyVO;
import com.team1.stelling.domain.vo.SubNovelVO;
import com.team1.stelling.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@Slf4j
@RequestMapping("/novelDetail/*")
@RequiredArgsConstructor
public class NovelDetailViewController {

    private  final NovelService novelService;
    private final UserService userService;
    private final SubNovelService subNovelService;
    private final NovelFileService novelFileService;
    private final ReplyService replyService;



    @GetMapping("/{subNovelNumber}/{num}")
    @ResponseBody
    public int subNovelLikeCount(@PathVariable("subNovelNumber")Long subNovelNumber, @PathVariable("num") int num){
       SubNovelVO subNovelVO = subNovelService.get(subNovelNumber);
       subNovelVO.updateSubNovelLickCount(num);
       subNovelService.register(subNovelVO);
       return subNovelVO.getSubNovelLikeCount();
    }

    /*댓글 신고*/
    @GetMapping("/siren")
    @ResponseBody
    public String siren(Long replyNumber){
        ReplyVO replyVO= replyService.get(replyNumber);
        replyVO.updatereplyReport();
        replyService.register(replyVO);
        return "신고완료";
    }




}