package com.team1.stelling.domain.vo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="TBL_NOVEL")
@SequenceGenerator(name = "NOVEL_SEQ" , allocationSize = 1)
@Getter
@ToString(of = {
        "novelNumber","novelTitle","novelUserNick","novelHashtag","novelUploadDate", "novelUpdateDate", "novelMonday", "novelTuesDay",
        "novelWednesDay", "novelThursDay", "novelFriDay", "novelSaturDay", "novelSunDay", "novelCategory", "novelStatus", "novelSerialsStatus",
        "novelIntro"})
@NoArgsConstructor
public class NovelVO {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "NOVEL_SEQ")
    @Column(name = "NOVEL_NUMBER")
   private Long novelNumber;  // 노벨번호

/* Column(name = "USER_NUMBER")
   private int userNumber; // 양방향 */
   @ManyToOne
   @JoinColumn(name ="USER_NUMBER")
   private UserVO userVO;
                     
   @Column(name = "NOVEL_TITLE")
   private String novelTitle;  // 소설제목
   @Column(name = "USER_NICKNAME")
   private String novelUserNick;   // 유저 닉네임
   @Column(name = "NOVEL_HASHTAG")
   private String novelHashtag; /*예) #로맨스 #메카물 #마법사*/
   @Column(name = "NOVEL_UPLOADDATE")
   private Date novelUploadDate; // 업로드(작성) 시간
   @Column(name = "NOVEL_UPDATEDATE")
   private Date novelUpdateDate; // 수정 시간
   @Column(name = "NOVEL_MONDAY")
   private int novelMonday; // 월요일
   @Column(name = "NOVEL_TUESDAY")
   private int novelTuesDay; // 화요일
   @Column(name = "NOVEL_WEDNESDAY")
   private int novelWednesDay; // 수요일
   @Column(name = "NOVEL_THURSDAY")
   private int novelThursDay; // 목요일
   @Column(name = "NOVEL_FRIDAY")
   private int novelFriDay; // 금요일
   @Column(name = "NOVEL_SATURDAY")
   private int novelSaturDay; // 토요일
   @Column(name = "NOVEL_SUNDAY")
   private int novelSunDay; // 일요일
   @Column(name = "NOVEL_CATEGORY")
   private String novelCategory; /* 큰 카테고리 --> 첫번째 태그 연결*/
   @Column(name = "NOVEL_STATUS")
   private int novelStatus;  /*작품 상태 0휴재, 1연재, 2완결, 3 숨김*/
   @Column(name = "NOVEL_SERIALSTATUS")
   private int novelSerialsStatus; /*정기연재 OR 자유연재 상태*/
   @Column(name = "NOVEL_INTRO")
   private String novelIntro; /* 소설 소개*/

    @Builder
    public NovelVO(Long novelNumber, UserVO userVO, String novelTitle, String novelUserNick, String novelHashtag, Date novelUploadDate, Date novelUpdateDate, int novelMonday, int novelTuesDay, int novelWednesDay, int novelThursDay, int novelFriDay, int novelSaturDay, int novelSunDay, String novelCategory, int novelStatus, int novelSerialsStatus, String novelIntro) {
        this.novelNumber = novelNumber;
        this.userVO = userVO;
        this.novelTitle = novelTitle;
        this.novelUserNick = novelUserNick;
        this.novelHashtag = novelHashtag;
        this.novelUploadDate = novelUploadDate;
        this.novelUpdateDate = novelUpdateDate;
        this.novelMonday = novelMonday;
        this.novelTuesDay = novelTuesDay;
        this.novelWednesDay = novelWednesDay;
        this.novelThursDay = novelThursDay;
        this.novelFriDay = novelFriDay;
        this.novelSaturDay = novelSaturDay;
        this.novelSunDay = novelSunDay;
        this.novelCategory = novelCategory;
        this.novelStatus = novelStatus;
        this.novelSerialsStatus = novelSerialsStatus;
        this.novelIntro = novelIntro;
    }
}
