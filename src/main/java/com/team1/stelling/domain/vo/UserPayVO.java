package com.team1.stelling.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserPayVO {
    private Long userNumber;
    private String userNickName;
    private String userEmail;
    private String userPhoneNum;
}
