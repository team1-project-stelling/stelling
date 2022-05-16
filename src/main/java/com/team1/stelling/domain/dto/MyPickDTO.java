package com.team1.stelling.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class MyPickDTO {

    @NotEmpty @NotNull
    private int myPickPick; /*찜이면 1 아니면 0 ?*/
}
