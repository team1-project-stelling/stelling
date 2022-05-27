package com.team1.stelling.paylod.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class UserRequest {
    private String userId;
    private String userPw;
}
