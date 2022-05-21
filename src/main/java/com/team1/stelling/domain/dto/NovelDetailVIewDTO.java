package com.team1.stelling.domain.dto;

import com.team1.stelling.domain.vo.SubNovelVO;
import com.team1.stelling.domain.vo.SupportVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class NovelDetailVIewDTO {

    private String novelContent;
    private String writerComment;
    private int likeCount;
    private SupportVO supportVO;
    private List<SubNovelVO> subNovelTitleList;

}
