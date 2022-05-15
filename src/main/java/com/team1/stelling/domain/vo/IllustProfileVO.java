package com.team1.stelling.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;


@Getter
@Setter
public class IllustProfileVO {
    /* 시퀀스 ->   ILLUSTPROFILE_SEQ */
    private Long illustProfileNumber; // 일러스트 프로파일 번호
    private Long  userNumber; // 유저 번호 FK
    private String illustProfileShortIntro; // 짧은 소개
    private String illustProfileDetailIntro; // 자세한 소개
    private String illustProfileCategory; // 주 활동 카테고리
    private String illustProfileWebSite; // 웹사이트 링크

}



