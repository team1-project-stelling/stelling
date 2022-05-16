package com.team1.stelling.domain.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
public class InquiryVO {
    /* 시퀀스 - > INQUIRY_SEQ */
   private Long inquiryNumber; // 1:1문의 번호
   private Long userNumber;/*닉네임을 가져오기 위한 FK*/
   private String inquiryTitle;/*문의 제목*/
   private String inquiryContent;/*문의 내용*/
   private String inquiryAnswer;/*문의 답변*/
   private int inquiryStatus;/*답변 대기중, 답변 완료*/
   private Date inquiryDate; // 1대1문의 작성시간
   private Date inquiryRepDate; // 답변 시간
}
