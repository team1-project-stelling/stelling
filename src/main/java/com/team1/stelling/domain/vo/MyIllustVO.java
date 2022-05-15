package com.team1.stelling.domain.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class MyIllustVO {
    /* 시퀀스 -> MYILLUST_SEQ  */
    private Long myIllustNumber; // 일러스트 번호
    private int myIllustStatus; /* 찜이면 1 아니면 0 */
    private Long illustNumber;  /*FK 찜한 일러스트 번호*/
    private Long userNumber; /*FK, 찜한 회원번호*/

}
