package com.team1.stelling.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NovelRankingDTO {
    private Long novelNumber ;
    private Long userNumber   ;
    private String userNickName ;
    private String  novelTitle   ;
    private String novelHashtag  ;
    private Date novelUploadDate  ;
    private Date novelUpdateDate  ;
    private String  novelCategory  ;
    private int novelStatus       ;
    private String novelSerialStatus  ;
    private String novelIntro   ;
    private String novelFileName ;
    private String novelUploadPath ;
    private String novelUuid  ;
    private int novelRoundaboutTotal  ;
    private int novelLikeCountTotal    ;
    private int novelViewCountTotal    ;
}
