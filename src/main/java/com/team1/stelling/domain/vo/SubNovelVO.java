package com.team1.stelling.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="TBL_SUBNOVEL")
@SequenceGenerator(name = "SUBNOVEL_SEQ" , allocationSize = 1)
@Getter
@ToString(of = { "subNovelNumber", "subNovelTitle", "subNovelWriterComment", "subNovelUploadDate", "subNovelUpdateDate","subNovelViewCount","subNovelLickCount","subNovelStatus" })
@NoArgsConstructor
public class SubNovelVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBNOVEL_SEQ")
    @Column(name = "SUBNOVEL_NUMBER ")
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
    @Column(name = "SUBNOVEL_UPLOADDATE ")
    private Date subNovelUploadDate;  // 회차 업로드 시간
    @Column(name = "SUBNOVEL_UPDATEDATE ")
    private  Date subNovelUpdateDate;  // 회차 수정 시간
    @Column(name = "SUBNOVEL_VIEWCOUNT ")
    private  int subNovelViewCount; // 조회수
    @Column(name = "SUBNOVEL_LIKECOUNT ")
    private int subNovelLickCount;  // 회차 좋아요
    @Column(name = "SUBNOVEL_STATUS ")
    private  int subNovelStatus;/*회차 상태 0 숨김, 1 보여짐*/

    @Builder
    public SubNovelVO(Long subNovelNumber, NovelVO novelVO, UserVO userVO, String subNovelTitle, String subNovelWriterComment, Date subNovelUploadDate, Date subNovelUpdateDate, int subNovelViewCount, int subNovelLickCount, int subNovelStatus) {
        this.subNovelNumber = subNovelNumber;
        this.novelVO = novelVO;
        this.userVO = userVO;
        this.subNovelTitle = subNovelTitle;
        this.subNovelWriterComment = subNovelWriterComment;
        this.subNovelUploadDate = subNovelUploadDate;
        this.subNovelUpdateDate = subNovelUpdateDate;
        this.subNovelViewCount = subNovelViewCount;
        this.subNovelLickCount = subNovelLickCount;
        this.subNovelStatus = subNovelStatus;
    }
}
