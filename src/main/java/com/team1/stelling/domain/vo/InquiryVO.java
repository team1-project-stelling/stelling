package com.team1.stelling.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Table(name ="TBL_INQUIRY")
@Getter
@Setter
@ToString(of = {"inquiryNumber","inquiryTitle","inquiryContent","inquiryAnswer","inquiryStatus","inquiryDate","inquiryRepDate"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InquiryVO {
   /* 시퀀스 - > INQUIRY_SEQ */
   @SequenceGenerator(name ="INQUIRY_SEQ" , allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INQUIRY_SEQ")
   @Id
   @Column(name = "INQUIRY_NUMBER")
   private Long inquiryNumber; // 1:1문의 번호
   @ManyToOne
   @JoinColumn(name = "USER_NUMBER")
   private UserVO userVO;/*닉네임을 가져오기 위한 FK*/
   @Column(name = "INQUIRY_TITLE")
   private String inquiryTitle;/*문의 제목*/
   @Column(name = "INQUIRY_CONTENT")
   private String inquiryContent;/*문의 내용*/
   @Column(name = "INQUIRY_ANSWER")
   private String inquiryAnswer;/*문의 답변*/
   @Column(name = "INQUIRY_STATUS")
   private int inquiryStatus;/*답변 대기중, 답변 완료*/
   @Column(name = "INQUIRY_DATE")
   private Date inquiryDate; // 1대1문의 작성시간(요청)
   @Column(name = "INQUIRY_REPDATE")
   private Date inquiryRepDate; // 답변 시간

   public void updateInquiryNumber(Long inquiryNumber) {
      this.inquiryNumber = inquiryNumber;
   }

   public void updateInquiryTitle(String inquiryTitle) {
      this.inquiryTitle = inquiryTitle;
   }

   public void updateInquiryContent(String inquiryContent) {
      this.inquiryContent = inquiryContent;
   }

   public void updateInquiryAnswer(String inquiryAnswer) {
      this.inquiryAnswer = inquiryAnswer;
   }

   public void updateInquiryStatus(int inquiryStatus) {
      this.inquiryStatus = inquiryStatus;
   }

   public void updateInquiryDate(Date inquiryDate) {
      this.inquiryDate = inquiryDate;
   }

   public void updateInquiryRepDate(Date inquiryRepDate) {
      this.inquiryRepDate = inquiryRepDate;
   }
}