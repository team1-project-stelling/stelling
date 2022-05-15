package com.team1.stelling.domain.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
public class ReplyVO {
    /* 시퀀스 ->  REPLY_SEQ  */


   private Long replyNumber; // 댓글 번호 (DB상의 번호)
   private Long userNumber; // FK 유저번호
   private Long novelNumber; // FK 소설번호
   private Long subNovelNumber; //fk 회차번호
   private String replyContent; // 댓글 내용
   private Date replyUploadDate; // 댓글 등록 시간
   private Date replyUpdateDate; // 댓글 수정 시간
   private int replyUp;/*추천*/
   private int replyReport;/*신고*/



}
