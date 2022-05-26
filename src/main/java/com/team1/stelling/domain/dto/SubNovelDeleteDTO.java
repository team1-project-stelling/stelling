package com.team1.stelling.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class SubNovelDeleteDTO {
    Long[] deleteNumber;
    Long novelNumber;

    SubNovelDeleteDTO(){
        ;
    }
}
