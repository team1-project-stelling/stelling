package com.team1.stelling.domain.criteria;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class MainCriteria {
    @NonNull
    private String keyword;

    public MainCriteria(){this("searchAll");}
}
