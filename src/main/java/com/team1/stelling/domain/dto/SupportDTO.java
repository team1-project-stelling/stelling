package com.team1.stelling.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SupportDTO {
    private Long supportSponser;
    private Long supportTotal;
}
