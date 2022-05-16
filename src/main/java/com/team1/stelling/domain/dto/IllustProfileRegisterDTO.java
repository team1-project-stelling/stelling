package com.team1.stelling.domain.dto;

import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IllustProfileRegisterDTO {
    private Long illustProfileNumber; // 일러스트 프로파일 번호
    private UserVO userVO; // 유저 번호 FK
    private String illustProfileShortIntro; // 짧은 소개
    private String illustProfileDetailIntro; // 자세한 소개
    private String illustProfileCategory; // 주 활동 카테고리
    private String illustProfileWebSite; // 웹사이트 링크

    @Builder
    public IllustProfileRegisterDTO(Long illustProfileNumber, UserVO userVO, String illustProfileShortIntro, String illustProfileDetailIntro, String illustProfileCategory, String illustProfileWebSite){
        this.illustProfileNumber = illustProfileNumber;
        this.userVO = userVO;
        this.illustProfileShortIntro = illustProfileShortIntro;
        this.illustProfileDetailIntro = illustProfileDetailIntro;
        this.illustProfileCategory = illustProfileCategory;
        this.illustProfileWebSite = illustProfileWebSite;
    }

    public IllustProfileVO toEntity(){
        return IllustProfileVO.builder()
                .illustProfileNumber(illustProfileNumber)
                .userVO(userVO)
                .illustProfileShortIntro(illustProfileShortIntro)
                .illustProfileDetailIntro(illustProfileDetailIntro)
                .illustProfileCategory(illustProfileCategory)
                .illustProfileWebSite(illustProfileWebSite)
                .build();
    }
}

