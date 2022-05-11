package com.team1.stelling.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

// 소설 찜한 테이블
@Component
@Data
public class MyPickVO {
    /* 시퀀스 -> MYPICK_SEQ */
   private Long myPickNumber; // 번호
   private int myPickPick; /*찜이면 1 아니면 0 ?*/
   private Long novelNumber; /* 찜한 소설의 번호 FK  */
   private Long userNumber; // 찜한 사용자  FK

}
