package com.team1.stelling.domain.vo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="TBL_USER")
@SequenceGenerator(name = "USER_SEQ" , allocationSize = 1)
@Getter
@NoArgsConstructor
public class UserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @Column(name = "USER_NUMBER")
    private Long userNumber; // 회원번호
    @Column(name = "USER_ID")
    private String userId;   // 아이디
    @Column(name = "USER_PW")
    private String userPw;    // 비밀번호
    @Column(name = "USER_NICKNAME")
    private String userNickName; // 닉네임
    @Column(name = "USER_EMAIL")
    private String userEmail;   // 이메일
    @Column(name = "USER_GENDER")
    private String userGender;  // 성별
    @Column(name = "USER_PHONENUM")
    private String userPhoneNum;  //전화번호
    @Column(name = "USER_STATUS")
    private int userStatus;      // 회원 상태 0 - 일반회원 , 1 - 관리자 , 2- 휴면(탈퇴)
    @Column(name = "USER_COINBALANCE")
    private int userCoinBalance;  // 코인 잔액
    @Column(name = "USER_ACCESSTOKEN")
    private String userAccessToken; // 카카오 계정 이용시 발급 받는 토큰

    @Builder
    public UserVO(Long userNumber, String userId, String userPw, String userNickName, String userEmail, String userGender, String userPhoneNum, int userStatus, int userCoinBalance, String userAccessToken) {
        this.userNumber = userNumber;
        this.userId = userId;
        this.userPw = userPw;
        this.userNickName = userNickName;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userPhoneNum = userPhoneNum;
        this.userStatus = userStatus;
        this.userCoinBalance = userCoinBalance;
        this.userAccessToken = userAccessToken;
    }
}
