package com.team1.stelling.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NovelDTO {
    private String novelTitle;
    private String novelUploadPath;
    private String novelFileName;
}
