package com.team1.stelling.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class PayVO {
    /* 시퀀스 -> PAY_SEQ*/
   private Long payNumber; // 거래번호
   private Long userNumber; // FK, 구매한 사용자 번호
   private Long payCharge; /*실제 사용자가 결제한 금액*/
   private Long chargeTotal; /*총 결제 금액*/
   private int payCoinCount; /*거래에서 환전된 코인*/
   private Date payDate; // 거래일시
   private int payStatus; /* 환불 및 기타 상태 */
}
