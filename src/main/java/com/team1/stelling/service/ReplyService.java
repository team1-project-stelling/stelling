package com.team1.stelling.service;

import com.team1.stelling.domain.dao.ReplyDAO;
import com.team1.stelling.domain.repository.ReplyRepository;
import com.team1.stelling.domain.vo.ReplyVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReplyService{
    private final ReplyRepository replyRepository;

    public ReplyVO get(Long replyNo){return  replyRepository.findById(replyNo).get();}
    public List<ReplyVO> getList(){return replyRepository.findAll();}
    public void register(ReplyVO replyVo){replyRepository.save(replyVo);}
    public void modify(ReplyVO replyVO){
        replyVO.updateReplyUpdateDate();
        replyRepository.save(replyVO);
    }

}
