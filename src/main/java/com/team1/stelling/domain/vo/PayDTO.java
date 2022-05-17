package com.team1.stelling.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PayDTO {
    private Long userNumber;
    private Long chargeTotal;
}
