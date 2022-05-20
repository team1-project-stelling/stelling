package com.team1.stelling.domain.vo;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name ="TBL_USER")
@SequenceGenerator(name = "USER_SEQ" , allocationSize = 1)
@Getter
@Setter
@ToString
@Data
@DynamicInsert
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
    private int userGender;  // 성별
    @Column(name = "USER_PHONENUM")
    private String userPhoneNum;  //전화번호
    @Column(name = "USER_STATUS")
    private int userStatus;      // 회원 상태 0 - 일반회원 , 1 - 관리자 , 2- 휴면(탈퇴)
    @Column(name = "USER_COINBALANCE")
    private int userCoinBalance;  // 코인 잔액
    @Column(name = "USER_FILEPATH")
    private String userFilePath;  // 파일 경로
    @Column(name = "USER_UUID")
    private String userUuid;  // uuid
    @Column(name = "USER_FILENAME")
    private String userFileName;  // 파일 이름
    @Column(name = "USER_ACCESSTOKEN")
    private String userAccessToken; // 카카오 계정 이용시 발급 받는 토큰

    public void updateUserPw(String userPw) { this.userPw = userPw; }
    public void updateUserNickName(String userNickName) { this.userNickName = userNickName; }
    public void updateUserEmail(String userEmail) { this.userEmail = userEmail; }
    public void updateUserGender(int userGender) { this.userGender = userGender; }
    public void updateUserPhoneNum(String userPhoneNum) { this.userPhoneNum = userPhoneNum; }
    public void updateUserStatus(int userStatus) { this.userStatus = userStatus; }
    public void updateUserCoinBalance(int userCoinBalance) { this.userCoinBalance = userCoinBalance; }
    public void updateUserAccessToken(String userAccessToken) { this.userAccessToken = userAccessToken; }
    public void updateUserUuid(String userUuid){this.userUuid = userUuid;}
    public void updateFilePate(String userFilePath){this.userFilePath = userFilePath;}
    public void updateFileName(String userFileName){this.userFileName = userFileName;}

    @Builder
    public UserVO(Long userNumber, String userId, String userPw, String userNickName,
                  String userEmail, int userGender, String userPhoneNum,
                  int userStatus, int userCoinBalance, String userFilePath, String userUuid,
                  String userFileName, String userAccessToken)
    {
        this.userNumber = userNumber;
        this.userId = userId;
        this.userPw = userPw;
        this.userNickName = userNickName;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userPhoneNum = userPhoneNum;
        this.userStatus = userStatus;
        this.userCoinBalance = userCoinBalance;
        this.userFilePath = userFilePath;
        this.userUuid = userUuid;
        this.userFileName = userFileName;
        this.userAccessToken = userAccessToken;
    }
}
