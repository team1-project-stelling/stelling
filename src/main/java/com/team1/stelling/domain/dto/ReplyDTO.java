package com.team1.stelling.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReplyDTO {
    private Long userNumber;
    private Long subNovelNumber;
    private Long novelNumber;
    private String replyContent;

}
