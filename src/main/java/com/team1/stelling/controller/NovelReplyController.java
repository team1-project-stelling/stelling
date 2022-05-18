package com.team1.stelling.controller;


import com.team1.stelling.domain.dto.ReplyDTO;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.domain.vo.ReplyVO;
import com.team1.stelling.domain.vo.SubNovelVO;
import com.team1.stelling.domain.vo.UserVO;
import com.team1.stelling.service.NovelService;
import com.team1.stelling.service.ReplyService;
import com.team1.stelling.service.SubNovelService;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public void ReplyRegister(@RequestBody ReplyDTO replyDTO){
        log.info("-------------------------------------------------------------------------------------------");
        log.info("replyRegister컨트롤러들어옴");
        log.info("-------------------------------------------------------------------------------------------");
        ReplyVO replyVO = new ReplyVO();
        NovelVO novelVO = novelService.get(replyDTO.getNovelNumber());
        UserVO userVO = userService.get(replyDTO.getUserNumber());
        SubNovelVO subNovelVO =subNovelService.get(replyDTO.getSubNovelNumber());
        replyVO.setReplyContent(replyDTO.getReplyContent());
        replyVO.setNovelVO(novelVO);
        replyVO.setUserVO(userVO);
        replyVO.setSubNovelVO(subNovelVO);
        replyService.register(replyVO);
        log.info(replyVO.toString());
    }

}
