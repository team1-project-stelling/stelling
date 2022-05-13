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
@Table(name ="TBL_SUBNOVEL")
@SequenceGenerator(name = "SUBNOVEL_SEQ" , allocationSize = 1)
@Getter
@Setter
@ToString(of = { "subNovelNumber", "subNovelTitle", "subNovelWriterComment", "subNovelUploadDate", "subNovelUpdateDate","subNovelViewCount","subNovelLickCount","subNovelStatus" })
@AllArgsConstructor
public class SubNovelVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBNOVEL_SEQ")
    @Column(name = "SUBNOVEL_NUMBER")
    Long subNovelNumber; // 회차 번호


    @ManyToOne
    @JoinColumn(name ="NOVEL_NUMBER")
   private NovelVO novelVO; /*FK 소설 번호 */

    @ManyToOne
    @JoinColumn(name = "USER_NUMBER")
    private UserVO userVO; //FK  유저번호

    @Column(name = "SUBNOVEL_TITLE ")
    private  String subNovelTitle; //   회차제목
    @Column(name = "SUBNOVEL_WRITERCOMMENT")
    private String subNovelWriterComment; /*작가의 작품 후기(매 회차 마다)*/
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SUBNOVEL_UPLOADDATE",updatable = false)
    private Date subNovelUploadDate;  // 회차 업로드 시간
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SUBNOVEL_UPDATEDATE")
    private  Date subNovelUpdateDate;  // 회차 수정 시간
    @Column(name = "SUBNOVEL_VIEWCOUNT")
    private  int subNovelViewCount; // 조회수
    @Column(name = "SUBNOVEL_LIKECOUNT")
    private int subNovelLickCount;  // 회차 좋아요
    @Column(name = "SUBNOVEL_STATUS")
    private  int subNovelStatus;/*회차 상태 0 숨김, 1 보여짐*/

    public void updateSubNovelTitle(String subNovelTitle) { this.subNovelTitle = subNovelTitle;}

    public void updateSubNovelWriterComment(String subNovelWriterComment) { this.subNovelWriterComment = subNovelWriterComment; }

    public void updateSubNovelUpdateDate() { this.subNovelUpdateDate = new Date(); }

    public void updateSubNovelViewCount() { this.subNovelViewCount++; }

    public void updateSubNovelLickCount() { this.subNovelLickCount++; }

    public void updateSubNovelStatus(int subNovelStatus) { this.subNovelStatus = subNovelStatus; }

    public SubNovelVO() {;}

    @Builder
    public SubNovelVO(Long subNovelNumber, NovelVO novelVO, UserVO userVO, String subNovelTitle, String subNovelWriterComment, String subNovelUploadDate, String subNovelUpdateDate, int subNovelViewCount, int subNovelLickCount, int subNovelStatus) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.subNovelNumber = subNovelNumber;
        this.novelVO = novelVO;
        this.userVO = userVO;
        this.subNovelTitle = subNovelTitle;
        this.subNovelWriterComment = subNovelWriterComment;
        try {
            if(subNovelUploadDate != null ) { this.subNovelUploadDate = sdf.parse(subNovelUploadDate); }
            if(subNovelUpdateDate != null ) { this.subNovelUpdateDate = sdf.parse(subNovelUpdateDate); }
        } catch (ParseException e) { e.printStackTrace();}
        this.subNovelViewCount = subNovelViewCount;
        this.subNovelLickCount = subNovelLickCount;
        this.subNovelStatus = subNovelStatus;
    }
}
