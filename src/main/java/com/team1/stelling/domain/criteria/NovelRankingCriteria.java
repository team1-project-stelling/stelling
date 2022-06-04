package com.team1.stelling.domain.criteria;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.constraints.NotNull;

@Component
@Data
@RequiredArgsConstructor
public class NovelRankingCriteria {
    // 랭킹 조건
    @NonNull
    private String rankType;
    // 소설 상태
    @NonNull
    private String novelStatus;
    // 검색할 태그
    @NonNull
    private String keyword;
    // 요일
    @NonNull
    private int day; // 0 -월 ~ 6 -일
    public NovelRankingCriteria(){this("view","all","searchAll",-1);}
    public String getListLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("rankType",this.rankType)
                .queryParam("novelStatus",this.novelStatus)
                .queryParam("keyword",this.keyword)
                .queryParam("day",this.day);
       return builder.toUriString();
    }


}
