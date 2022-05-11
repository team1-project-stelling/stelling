package com.team1.stelling.domain.vo;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name ="TBL_ILLUSTPROFILE")
@SequenceGenerator(name ="ILLUSTPROFILE_SEQ" , allocationSize = 1)
@Getter
@ToString(of = {"illustProfileNumber","illustProfileShortIntro","illustProfileDetailIntro","illustProfileCategory","illustProfileWebSite"})
@NoArgsConstructor
public class IllustProfileVO {
    /* 시퀀스 ->   ILLUPROFILE_SEQ */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ILLUSTPROFILE_SEQ")
    @Value("ILLUPROFILE_NUMBER ")
    private Long illustProfileNumber; // 일러스트 프로파일 번호

    @ManyToOne
    @JoinColumn(name = "USER_NUMBER")
    private UserVO userVO; // 유저 번호 FK

    @Column(name = "ILLUSTPROFILE_SHORTINTRO")
    private String illustProfileShortIntro; // 짧은 소개
    @Column(name = "ILLUSTPROFILE_DETAILINTRO")
    private String illustProfileDetailIntro; // 자세한 소개
    @Column(name = "ILLUSTPROFILE_CATEGORY")
    private String illustProfileCategory; // 주 활동 카테고리
    @Column(name = "ILLUSTPROFILE_WEBSITE")
    private String illustProfileWebSite; // 웹사이트 링크

    @Builder

    public IllustProfileVO(Long illustProfileNumber, UserVO userVO, String illustProfileShortIntro, String illustProfileDetailIntro, String illustProfileCategory, String illustProfileWebSite) {
        this.illustProfileNumber = illustProfileNumber;
        this.userVO = userVO;
        this.illustProfileShortIntro = illustProfileShortIntro;
        this.illustProfileDetailIntro = illustProfileDetailIntro;
        this.illustProfileCategory = illustProfileCategory;
        this.illustProfileWebSite = illustProfileWebSite;
    }
}



