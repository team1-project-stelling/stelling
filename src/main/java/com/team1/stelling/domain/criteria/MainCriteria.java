package com.team1.stelling.domain.criteria;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@RequiredArgsConstructor
public class MainCriteria {
    @NonNull
    private String keyword;

    public MainCriteria(){this("searchAll");}
}
