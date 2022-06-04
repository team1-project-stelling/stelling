package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.vo.ReplyVO;
import com.team1.stelling.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReplyDAO {
    private final ReplyMapper replyMapper;

    public int register(ReplyVO replyVO){
        log.info("reply register...." + replyVO);
        return replyMapper.insert(replyVO);
    }

}
