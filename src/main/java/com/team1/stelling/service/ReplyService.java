package com.team1.stelling.service;

import com.team1.stelling.domain.vo.ReplyVO;
import org.springframework.stereotype.Service;

@Service
public interface ReplyService {
        public boolean register(ReplyVO replyVO);
}
