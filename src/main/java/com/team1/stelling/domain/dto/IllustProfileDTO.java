package com.team1.stelling.domain.dto;

import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class IllustProfileDTO {
    private String userNickName;
    private String userFilePath;
    private String userUuid;
    private String userFileName;
    private Long illustProfileNumber; // 일러스트 프로파일 번호
    private Long  userNumber; // 유저 번호 FK
    private String illustProfileShortIntro; // 짧은 소개
    private String illustProfileDetailIntro; // 자세한 소개
    private String illustProfileCategory; // 주 활동 카테고리
    private String illustProfileWebSite; // 웹사이트 링크

    public IllustProfileDTO(String userNickName, String userFilePath, String userUuid, String userFileName, Long illustProfileNumber, Long userNumber, String illustProfileShortIntro, String illustProfileDetailIntro, String illustProfileCategory, String illustProfileWebSite) {
        this.userNickName = userNickName;
        this.userFilePath = userFilePath;
        this.userUuid = userUuid;
        this.userFileName = userFileName;
        this.illustProfileNumber = illustProfileNumber;
        this.userNumber = userNumber;
        this.illustProfileShortIntro = illustProfileShortIntro;
        this.illustProfileDetailIntro = illustProfileDetailIntro;
        this.illustProfileCategory = illustProfileCategory;
        this.illustProfileWebSite = illustProfileWebSite;
    }
}
