package com.team1.stelling.domain.vo;


import lombok.*;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Generated;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Entity
@Table(name ="TBL_ILLUST")
@Getter @Setter
@ToString(of = {"illustNumber","illustTitle","illustContent","illustUploadDate","illustUpdateDate","illustHashTag","illustViewCount","illustLike","illustShortIntro", "illustFileName", "illustFilePath", "illustUuid"})
@AllArgsConstructor
@NoArgsConstructor
public class IllustVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ILLUST_NUMBER")
    private Long illustNumber;

    @ManyToOne
    @JoinColumn(name = "USER_NUMBER")
    private UserVO userVO; // 유저번호   /*작가 USERNUM - FK */

    @Column(name = "ILLUST_TITLE")
    private String illustTitle; // 일러스트 제목

    @Column(name = "ILLUST_CONTENT")
    private String illustContent;  // 일러스트 내용

    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ILLUST_UPLOADDATE" ,updatable = false)
    private Date illustUploadDate;   /* 작성 시간*/

    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ILLUST_UPDATEDATE")
    private Date illustUpdateDate; // 수정시간

    @Column(name = "ILLUST_HASHTAG")
    private String illustHashTag; // 해쉬태그

    @Column(name = "ILLUST_VIEWCOUNT")
    private int illustViewCount; // 조회수

    @Column(name = "ILLUST_LIKE")
    private int illustLike; /*각 일러스트에 대한 좋아요*/

    @Column(name = "ILLUST_SHORTINTRO")
    private String illustShortIntro;/*작품에 대한 짧은 소개*/

    @Column(name = "ILLUST_FILENAME")
    private String illustFileName;/*작품 name*/

    @Column(name = "ILLUST_FILEPATH")
    private String illustFilePath;/*작품 path*/

    @Column(name = "ILLUST_UUID")
    private String illustUuid;/*작품 uuid*/


    public void updateIllustTitle(String illustTitle) { this.illustTitle = illustTitle; }

    public void updateIllustContent(String illustContent) { this.illustContent = illustContent; }

    public void updateIllustUpdateDate() { this.illustUpdateDate = new Date(); }

    public void updateIllustHashTag(String illustHashTag) { this.illustHashTag = illustHashTag; }

    public void updateIllustViewCount() { this.illustViewCount++; }// 조회수는 한개씩 증가한다

    public void updateIllustLike() { this.illustLike++; } // 좋아요는 한개씩 증가한다

    public void updateIllustShortIntro(String illustShortIntro) { this.illustShortIntro = illustShortIntro; }


    @Builder
    public IllustVO(Long illustNumber, UserVO userVO, String illustTitle, String illustContent, String illustUploadDate, String illustUpdateDate, String illustHashTag, int illustViewCount, int illustLike, String illustShortIntro, String illustFileName, String illustFilePath, String illustUuid) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        this.illustNumber = illustNumber;
        this.userVO = userVO;
        this.illustTitle = illustTitle;
        this.illustContent = illustContent;
        this.illustHashTag = illustHashTag;
        this.illustViewCount = illustViewCount;
        this.illustLike = illustLike;
        this.illustShortIntro = illustShortIntro;
        this.illustFileName = illustFileName;
        this.illustFilePath = illustFilePath;
        this.illustUuid = illustUuid;
        try {
            if(illustUploadDate != null) { this.illustUploadDate = sdf.parse(illustUploadDate); }
            if(illustUpdateDate != null) { this.illustUpdateDate = sdf.parse(illustUpdateDate); }
        } catch (ParseException e) { e.printStackTrace();}


    }
}
