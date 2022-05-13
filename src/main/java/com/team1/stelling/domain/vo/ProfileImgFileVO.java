package com.team1.stelling.domain.vo;

import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Entity
@Table(name ="TBL_PROFILEIMGFILE")
@SequenceGenerator(name ="PROFILEIMGFILE_SEQ" , allocationSize = 1)
@Getter
@Setter
@ToString(of = {"profileImgNumber","profileImgFileFilePath","profileImgFileOriginFileName","profileImgFileFileName","profileImgFileUploadDate","profileImgFileUpdateDate"})
@AllArgsConstructor
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
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PROFILEIMGFILE_UPLOADDATE",updatable = false)
    private Date profileImgFileUploadDate; // 프로파일 업로드 시간
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PROFILEIMGFILE_UPDATEDATE")
    private Date profileImgFileUpdateDate; // 프로파일  수정 시간
    public void updateProfileImgFileFilePath(String profileImgFileFilePath) {this.profileImgFileFilePath = profileImgFileFilePath; }
    public void updateProfileImgFileOriginFileName(String profileImgFileOriginFileName) { this.profileImgFileOriginFileName = profileImgFileOriginFileName; }
    public void updateProfileImgFileFileName(String profileImgFileFileName) { this.profileImgFileFileName = profileImgFileFileName; }
    public void updateProfileImgFileUpdateDate() { this.profileImgFileUpdateDate = new Date(); }

    public ProfileImgFileVO() { ;}

    @Builder
    public ProfileImgFileVO(Long profileImgNumber, UserVO userVO, String profileImgFileFilePath, String profileImgFileOriginFileName, String profileImgFileFileName, String profileImgFileUploadDate, String profileImgFileUpdateDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.profileImgNumber = profileImgNumber;
        this.userVO = userVO;
        this.profileImgFileFilePath = profileImgFileFilePath;
        this.profileImgFileOriginFileName = profileImgFileOriginFileName;
        this.profileImgFileFileName = profileImgFileFileName;
        try {
            if(profileImgFileUploadDate != null) { this.profileImgFileUploadDate = sdf.parse(profileImgFileUploadDate); }
            if(profileImgFileUpdateDate != null) { this.profileImgFileUpdateDate = sdf.parse(profileImgFileUpdateDate); }
        } catch (ParseException e) { e.printStackTrace(); }
    }
}
