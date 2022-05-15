package com.team1.stelling.domain.vo;


import lombok.*;
import lombok.ToString;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@Table(name="TBL_ILLUSTPROFILE")
@Getter
@ToString(of = {"illustProfileNumber", "userNumber", "illustProfileShortIntro", "illustProfileDetailIntro", "illustProfileCategory", "illustProfileWebSite"} )
@NoArgsConstructor
public class IllustProfileVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ILLUSTPROFILE_SEQ")
    @SequenceGenerator(name="ILLUSTPROFILE_SEQ", allocationSize = 1)
    @Column(name = "ILLUSTPROFILE_NUMBER")
    private Long illustProfileNumber; // 일러스트 프로파일 번호
    @ManyToOne
    @JoinColumn(name = "USER_NUMBER")
    private UserVO userVO; // 유저 번호 FK

    @Column(name = "ILLUSTPROFILE_SHORTINTRO", insertable = true)
    private String illustProfileShortIntro; // 짧은 소개
    @Column(name = "ILLUSTPROFILE_DETAILINTRO", insertable = true)
    private String illustProfileDetailIntro; // 자세한 소개
    @Column(name = "ILLUSTPROFILE_CATEGORY", insertable = true)
    private String illustProfileCategory; // 주 활동 카테고리
    @Column(name = "ILLUSTPROFILE_WEBSITE", insertable = true)
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



