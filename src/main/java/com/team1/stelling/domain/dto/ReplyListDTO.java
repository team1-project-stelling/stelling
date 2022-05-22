package com.team1.stelling.domain.dto;

import com.team1.stelling.domain.vo.ReplyVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ReplyListDTO {
    List<ReplyVO> replyVOList;
    List<UserVO> userVOList;

    public ReplyListDTO(List<ReplyVO> replyVOList, List<UserVO> userVOList) {
        this.replyVOList = replyVOList;
        this.userVOList = userVOList;
    }
}
