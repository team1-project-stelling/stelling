package com.team1.stelling.domain.criteria;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class IllustListCriteria {
//    인기순 or 최신순
    @NonNull
    private String type;

    @NonNull
    private String keyword;

    public IllustListCriteria(){this("like", "searchAll");}

}
