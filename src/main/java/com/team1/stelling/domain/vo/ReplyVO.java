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
@Table(name="TBL_REPLY")
@SequenceGenerator(name ="REPLY_SEQ", allocationSize = 1)
@ToString(of ={
        "replyNumber", "replyContent", "replyUploadDate", "replyUpdateDate", "replyUp", "replyReport"
})
@Getter
@Setter
@NoArgsConstructor
public class ReplyVO {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPLY_SEQ")
   @Column(name="REPLY_NUMBER")
   Long replyNumber; // 댓글 번호 (DB상의 번호)

   @ManyToOne
   @JoinColumn(name="USER_NUMBER")
   private UserVO userVO; // FK 유저번호

   @ManyToOne
   @JoinColumn(name="NOVEL_NUMBER")
   private NovelVO novelVO; // FK 소설번호

   @ManyToOne
   @JoinColumn(name="SUBNOVEL_NUMBER")
   private SubNovelVO subNovelVO; //fk 회차번호

   @Column(name="REPLY_CONTENT")
   private String replyContent; // 댓글 내용

   @Generated(GenerationTime.INSERT)
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name="REPLY_UPLOADDATE", updatable = false)
   private Date replyUploadDate; // 댓글 등록 시간

   @Generated(GenerationTime.INSERT)
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name="REPLY_UPDATEDATE")
   private Date replyUpdateDate; // 댓글 수정 시간

   @Column(name="REPLY_UP")
   private int replyUp;/*추천*/

   @Column(name="REPLY_REPORT")
   private int replyReport;/*신고*/

   public void updateReplyContent(String replyContent){this.replyContent= replyContent;}
   public void updateReplyUpdateDate(){this.replyUpdateDate = new Date();}
   public void updateReplyUp(int num){this.replyUp= this.replyUp+num;}

   @Builder
   public ReplyVO(Long replyNumber, UserVO userVO, NovelVO novelVO, SubNovelVO subNovelVO, String replyContent, String replyUploadDate, String replyUpdateDate, int replyUp, int replyReport) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      this.replyNumber = replyNumber;
      this.userVO = userVO;
      this.novelVO = novelVO;
      this.subNovelVO = subNovelVO;
      this.replyContent = replyContent;
      try {
         if(replyUploadDate != null ) { this.replyUploadDate = sdf.parse(replyUploadDate); }
         if(replyUpdateDate != null ) { this.replyUpdateDate = sdf.parse(replyUpdateDate); }
      } catch (ParseException e) { e.printStackTrace();}
      this.replyUp = replyUp;
      this.replyReport = replyReport;
   }
}
