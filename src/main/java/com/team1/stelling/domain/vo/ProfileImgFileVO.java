package com.team1.stelling.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="TBL_PROFILEIMGFILE")
@SequenceGenerator(name ="PROFILEIMGFILE_SEQ" , allocationSize = 1)
@Getter
@ToString(of = {"profileImgNumber","profileImgFileFilePath","profileImgFileOriginFileName","profileImgFileFileName","profileImgFileUploadDate","profileImgFileUpdateDate"})
@NoArgsConstructor
public class ProfileImgFileVO {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "PROFILEIMGFILE_SEQ")
    @Column(name = "PROFILEIMGFILE_NUMBER")
    private Long profileImgNumber; // 프로파일 이미지 번호 PK

    @ManyToOne
    @JoinColumn(name = "USER_NUMBER")
    private UserVO userVO; // USER_NUMBER FK
    @Column(name = "PROFILEIMGFILE_FILEPATH")
    private String profileImgFileFilePath; // 프로파일 이미지 파일
    @Column(name = "PROFILEIMGFILE_ORIGINFILENAME")
    private String profileImgFileOriginFileName; // 프로파일 이미지원본이름
    @Column(name = "PROFILEIMGFILE_FILENAME")
    private String profileImgFileFileName; // 프로파일 이미지 파일네임
    @Column(name = "PROFILEIMGFILE_UPLOADDATE")
    private Date profileImgFileUploadDate; // 프로파일 업로드 시간
    @Column(name = "PROFILEIMGFILE_UPDATEDATE")
    private Date profileImgFileUpdateDate; // 프로파일  수정 시간

    public ProfileImgFileVO(Long profileImgNumber, UserVO userVO, String profileImgFileFilePath, String profileImgFileOriginFileName, String profileImgFileFileName, Date profileImgFileUploadDate, Date profileImgFileUpdateDate) {
        this.profileImgNumber = profileImgNumber;
        this.userVO = userVO;
        this.profileImgFileFilePath = profileImgFileFilePath;
        this.profileImgFileOriginFileName = profileImgFileOriginFileName;
        this.profileImgFileFileName = profileImgFileFileName;
        this.profileImgFileUploadDate = profileImgFileUploadDate;
        this.profileImgFileUpdateDate = profileImgFileUpdateDate;
    }
}
