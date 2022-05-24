package com.team1.stelling.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDTO {
    private String userNumber;
    private String userId;
    private String userEmail;
    private String userNick;
    private String userPw;
}
