package com.team1.stelling.controller;


import com.team1.stelling.domain.dto.ReplyDTO;
import com.team1.stelling.domain.dto.ReplyListDTO;
import com.team1.stelling.domain.vo.*;
import com.team1.stelling.service.NovelService;
import com.team1.stelling.service.ReplyService;
import com.team1.stelling.service.SubNovelService;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/reply/*")
@RequiredArgsConstructor
public class NovelReplyController {
    private final ReplyService replyService;
    private final UserService userService;
    private final NovelService novelService;
    private final SubNovelService subNovelService;


    @PostMapping(value = "/add", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public String replyRegister(@RequestBody ReplyDTO replyDTO){
        log.info("-------------------------------------------------------------------------------------------");
        log.info("replyRegister컨트롤러들어옴");
        log.info("-------------------------------------------------------------------------------------------");

        replyService.register(ReplyVO.builder().novelVO(novelService.get(replyDTO.getNovelNumber()))
                    .subNovelVO(subNovelService.get(replyDTO.getSubNovelNumber()))
                    .userVO(userService.get(replyDTO.getUserNumber()))
                    .replyContent(replyDTO.getReplyContent()).build());
        return "등록완료";
    }
    @Transactional
    @GetMapping("/list/{subNovelNumber}")
    public ReplyListDTO replygetList(@PathVariable("subNovelNumber") Long subNovelNumber){
          return new ReplyListDTO(replyService.getList(subNovelNumber),replyService.getUserList(subNovelNumber));
    }

    @GetMapping("/repliesTest/{subNovelNumber}")
    public List<ReplyVO> getList(@PathVariable Long subNovelNumber){
        return replyService.getList(subNovelNumber);
    }

    @GetMapping("/{replyNum}/{num}")
    public void replyUp(@PathVariable("replyNum") Long replyNum, @PathVariable("num")int num){
        ReplyVO replyVO = replyService.get(replyNum);
        replyVO.updateReplyUp(num);
        replyService.register(replyVO);
        log.info("===============================================================================================");
        log.info("리플라이 좋아요 갯수: "+replyVO.getReplyUp());
    }

    //최신순 댓글 총 목록
    @GetMapping("/getReplyLists/latest")
    public ReplyListDTO getReplyLists(Long novelNumber){
        List<ReplyVO> replyVOList =replyService.getReplyListLatest(novelNumber);
        List<UserVO> userVOList=replyVOList.stream().map(v->v.getUserVO()).collect(Collectors.toList());
        ReplyListDTO result = new ReplyListDTO(replyVOList,userVOList);

        return result;
    }


    }


