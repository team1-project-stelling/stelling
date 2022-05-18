package com.team1.stelling.domain.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
public class NovelFileDTO {
    private String content;
    private String subNovelTitle;
    private String subNovelWriterComment;
    private Long novelNumber;
    private Long userNumber;


}
