package com.team1.stelling.domain.dto;

import com.team1.stelling.domain.vo.ReplyVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class ReplyUserDTO {
    private Page<ReplyVO> replyVOList;
    private Page<UserVO> userVOList;
    private Pageable pageable;

    public ReplyUserDTO(){;}
}
