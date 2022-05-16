package com.team1.stelling.domain.vo;


import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Entity
@Table(name ="TBL_NOVEL")

@Getter
@ToString(of = {
        "novelNumber","novelTitle","novelHashtag","novelUploadDate", "novelUpdateDate", "novelMonday", "novelTuesDay",
        "novelWednesDay", "novelThursDay", "novelFriDay", "novelSaturDay", "novelSunDay", "novelCategory", "novelStatus", "novelSerialsStatus",
        "novelIntro","novelFileName","novelUploadPath","novelUUID","novelRoundAboutTotal","novelLikeCountTotal","novelViewCountTotal"})
@NoArgsConstructor
public class NovelVO {

    @Id
    @SequenceGenerator(name = "NOVEL_SEQ" , allocationSize = 1)
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
   @Column(name = "NOVEL_HASHTAG")
   private String novelHashtag; /*예) #로맨스 #메카물 #마법사*/
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "NOVEL_UPLOADDATE")
   private Date novelUploadDate; // 업로드(작성) 시간
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
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
   @Column(name = "NOVEL_FILENAME")
   private String novelFileName; /* 프로질 사진 이름 */
   @Column(name = "NOVEL_UPLOADPATH")
   private String novelUploadPath; /* 경로 */
   @Column(name = "NOVEL_UUID")
   private String novelUUID; /* UUID */
   @Column(name = "NOVEL_ROUNDABOUTTOTAL")
   private int novelRoundAboutTotal;
   @Column(name = "NOVEL_LIKECOUNTTOTAL")
   private int novelLikeCountTotal;
   @Column(name = "NOVEL_VIEWCOUNTTOTAL")
   private int novelViewCountTotal;


    public void updateNovelTitle(String novelTitle) { this.novelTitle = novelTitle;}
    public void updateNovelHashtag(String novelHashtag) { this.novelHashtag = novelHashtag; }
    public void updateNovelUpdateDate() { this.novelUpdateDate = new Date(); }
    public void updateNovelMonday(int novelMonday) { this.novelMonday += novelMonday; } // 구현할떄 상황에 맞게 변경하거나 다른 메소드 사용
    public void updateNovelTuesDay(int novelTuesDay) { this.novelTuesDay = novelTuesDay; }
    public void updateNovelWednesDay(int novelWednesDay) { this.novelWednesDay = novelWednesDay; }
    public void updateNovelThursDay(int novelThursDay) { this.novelThursDay = novelThursDay; }
    public void updateNovelFriDay(int novelFriDay) { this.novelFriDay = novelFriDay; }
    public void updateNovelSaturDay(int novelSaturDay) { this.novelSaturDay = novelSaturDay; }
    public void updateNovelSunDay(int novelSunDay) { this.novelSunDay = novelSunDay; }
    public void updateNovelCategory(String novelCategory) { this.novelCategory = novelCategory; }
    public void updateNovelStatus(int novelStatus) { this.novelStatus = novelStatus; }
    public void updateNovelSerialsStatus(int novelSerialsStatus) { this.novelSerialsStatus = novelSerialsStatus; }
    public void updateNovelIntro(String novelIntro) { this.novelIntro = novelIntro; }

    public void updateNovelFileName(String novelFileName) { this.novelFileName = novelFileName;}

    public void updateNovelUploadPath(String novelUploadPath) { this.novelUploadPath = novelUploadPath; }

    public void updateNovelUUID(String novelUUID) { this.novelUUID = novelUUID; }



    @Builder
    public NovelVO(Long novelNumber, UserVO userVO, String novelTitle, String novelHashtag, String novelUploadDate, String novelUpdateDate, int novelMonday, int novelTuesDay, int novelWednesDay, int novelThursDay, int novelFriDay, int novelSaturDay, int novelSunDay, String novelCategory, int novelStatus, int novelSerialsStatus, String novelIntro, String novelFileName, String novelUploadPath, String novelUUID, int novelRoundAboutTotal, int novelLikeCountTotal, int  novelViewCountTotal) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.novelNumber = novelNumber;
        this.userVO = userVO;
        this.novelTitle = novelTitle;
        this.novelHashtag = novelHashtag;
        try {
            if(novelUploadDate != null) { this.novelUploadDate = sdf.parse(novelUploadDate); }
            if(novelUpdateDate != null) { this.novelUpdateDate = sdf.parse(novelUpdateDate); }
        } catch (ParseException e) { e.printStackTrace(); }
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
        this.novelFileName = novelFileName;
        this.novelUploadPath = novelUploadPath;
        this.novelUUID = novelUUID;
        this.novelRoundAboutTotal = novelRoundAboutTotal;
        this.novelLikeCountTotal = novelLikeCountTotal ;
        this.novelViewCountTotal = novelViewCountTotal;
    }
}
