package com.team1.stelling.domain.vo;


import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
@Entity
@Table(name ="TBL_ILLUSTIMGFILE")
@SequenceGenerator(name ="ILLUSTIMGFILE_SEQ" , allocationSize = 1)
@Getter
@Setter
@ToString(of = {"illustImgFileNumber","illustImgFileFilePath","illustImgFileOriginUUID","illustImgFileFileName","illustImgFileUploadDate","illustImgFileUpdateDate"})
@AllArgsConstructor
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
   @Column(name = "ILLUSTIMGFILE_UUID")
   private String illustImgFileOriginUUID; // 일러스트파일 UUID
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

    public void updateillustImgFileOriginUUID(String illustImgFileOriginUUID) { this.illustImgFileOriginUUID = illustImgFileOriginUUID; }

    public void updateIllustImgFileFileName(String illustImgFileFileName) { this.illustImgFileFileName = illustImgFileFileName; }

    public IllustImgFileVO() {;}

    @Builder
    public IllustImgFileVO(Long illustImgFileNumber, IllustVO illustVO, UserVO userVO, String illustImgFileFilePath, String illustImgFileOriginUUID, String illustImgFileFileName, String illustImgFileUploadDate, String illustImgFileUpdateDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        this.illustImgFileNumber = illustImgFileNumber;
        this.illustVO = illustVO;
        this.userVO = userVO;
        this.illustImgFileFilePath = illustImgFileFilePath;
        this.illustImgFileOriginUUID = illustImgFileOriginUUID;
        this.illustImgFileFileName = illustImgFileFileName;

        try {
            if(illustImgFileUploadDate != null) { this.illustImgFileUploadDate = sdf.parse(illustImgFileUploadDate); }
            if(illustImgFileUpdateDate != null) { this.illustImgFileUpdateDate = sdf.parse(illustImgFileUpdateDate); }
        } catch (ParseException e) { e.printStackTrace();}

    }
}

