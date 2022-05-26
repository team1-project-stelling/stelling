package com.team1.stelling.domain.criteria;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class IllustCategoryCriteria {
    @NonNull
    private String type;

    @NonNull
    private String keyword;

    public IllustCategoryCriteria(){this("view","searchAll");}
}
