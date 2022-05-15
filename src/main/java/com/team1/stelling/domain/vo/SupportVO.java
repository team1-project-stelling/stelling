package com.team1.stelling.domain.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

/*후원(전체, 회차)*/
@Getter
@Setter
public class SupportVO {
    /* 시퀀스 -> SUPPORT_SEQ*/
   private Long supportNumber; // 후원번호
   private Long supportSponser; // FK (userNum) 후원한 사람
   private Long supportReceiver; // 후원받은사람
   private Long novelNumber; /*FK, 소설 번호*/
   private int supportCoin; /*후원 금액 = 차감 코인*/
   private Date supportDate; /*후원 날짜*/


}
