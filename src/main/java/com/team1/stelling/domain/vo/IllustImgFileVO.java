package com.team1.stelling.domain.vo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name ="TBL_ILLUSTIMGFILE")
@SequenceGenerator(name ="ILLUSTIMGFILE_SEQ" , allocationSize = 1)
@Getter
@ToString(of = {"illustImgFileNumber","illustImgFileFilePath","illustImgFileOriginFileName","illustImgFileFileName","illustImgFileUploadDate","illustImgFileUpdateDate"})
@NoArgsConstructor
@Slf4j
public class IllustImgFileVO {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ILLUSTIMGFILE_SEQ")
   @Column(name = "ILLUSTIMGFILE_NUMBER")
   private Long illustImgFileNumber; /* 이미지파일 번호 PK*/
   @ManyToOne
   @JoinColumn(name = "ILLUST_NUMBER")
   private IllustVO illustVO; /* 소속 일러스트 게시글 번호 */
   @ManyToOne
   @JoinColumn(name = "USER_NUMBER")
   private UserVO userVO;  // 유저 번호 fk
   @Column(name = "ILLUSTIMGFILE_FILEPATH")
   private String illustImgFileFilePath; // 일러스트 이미지 파일경로
   @Column(name = "ILLUSTIMGFILE_ORIGINFILENAME")
   private String illustImgFileOriginFileName; // 일러스트 원본 파일 이름
   @Column(name = "ILLUSTIMGFILE_FILENAME")
   private String illustImgFileFileName; // 일러스트 파일 이름
   @Generated(GenerationTime.INSERT)
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "ILLUSTIMGFILE_UPLOADDATE",updatable = false)
   private Date illustImgFileUploadDate; // 일러스트 등록 시간
   @Generated(GenerationTime.INSERT)
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "ILLUSTIMGFILE_UPDATEDATE")
   private Date illustImgFileUpdateDate; // 일러스트 수정시간


    public void updateIllustImgFileUpdateDate(){ this.illustImgFileUpdateDate =  new Date();}

    public void updateIllustImgFileFilePath(String illustImgFileFilePath) { this.illustImgFileFilePath = illustImgFileFilePath; }

    public void updateIllustImgFileOriginFileName(String illustImgFileOriginFileName) { this.illustImgFileOriginFileName = illustImgFileOriginFileName; }

    public void updateIllustImgFileFileName(String illustImgFileFileName) { this.illustImgFileFileName = illustImgFileFileName; }


    @Builder
    public IllustImgFileVO(Long illustImgFileNumber, IllustVO illustVO, UserVO userVO, String illustImgFileFilePath, String illustImgFileOriginFileName, String illustImgFileFileName, String illustImgFileUploadDate, String illustImgFileUpdateDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        this.illustImgFileNumber = illustImgFileNumber;
        this.illustVO = illustVO;
        this.userVO = userVO;
        this.illustImgFileFilePath = illustImgFileFilePath;
        this.illustImgFileOriginFileName = illustImgFileOriginFileName;
        this.illustImgFileFileName = illustImgFileFileName;

        try {
            if(illustImgFileUploadDate != null) { this.illustImgFileUploadDate = sdf.parse(illustImgFileUploadDate); }
            if(illustImgFileUpdateDate != null) { this.illustImgFileUpdateDate = sdf.parse(illustImgFileUpdateDate); }
        } catch (ParseException e) { e.printStackTrace();}

    }
}

