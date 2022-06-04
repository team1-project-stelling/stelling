package com.team1.stelling.domain.dto;

import com.team1.stelling.domain.vo.SupportVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class SupportUserDTO {
    private String userNickName;
    private int coin;
}
