package com.team1.stelling.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/*회차 구매 내역 */
@Data
public class BuyChapterVO {
    /* 시퀀스 -> BUYCHAPTER_SEQ*/
    private Long buyChapterNumber; /*회차 구매번호*/
    private Long novelNumber; /*FK, 소설번호*/
    private Long subNovelNumber; /*FK, 회차번호*/
    private Long userNumber;  /* FK 구매한 유저 */
    private int buyChapterCoin;  /*차감코인*/
    private Date buyChapterDate; /*구매날짜*/
    private int buyChapterStatus; /* 만약 취소나 환불이 있다면 -> 상태 */

}
