package com.team1.stelling.domain.vo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name ="TBL_NOVELFILE")
@SequenceGenerator(name ="NOVELFILE_SEQ" , allocationSize = 1)
@Getter
@ToString(of = {"novelFileNumber","novelFileFilePath","novelFileOriginalUUID","novelFileFileName","novelFileUploadUpdate", "novelFileUpdateDate"})
@NoArgsConstructor
public class NovelFileVO {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOVELFILE_SEQ")
   @Column(name = "NOVELFILE_NUMBER")
   private Long novelFileNumber; //*파일번호, 소설원고*//*

   @ManyToOne
   @JoinColumn(name = "SUBNOVEL_NUMBER")
   private SubNovelVO subNovelVO; //* FK *//*
   @ManyToOne
   @JoinColumn(name = "USER_NUMBER")
   private UserVO userVO;  // 유저번호 FK

   @ManyToOne
   @JoinColumn(name = "NOVEL_NUMBER")
   private NovelVO novelVO;  // 소설 번호 FK

   @Column(name = "NOVELFILE_FILEPATH")
   private String novelFileFilePath; // 소설 파일 경로
   @Column(name ="NOVELFILE_UUID")
   private String novelFileOriginalUUID; // 소설 원본 파일 UUID
   @Column(name ="NOVELFILE_FILENAME")
   private String novelFileFileName;  // 소설 파일 이름
   @Generated(GenerationTime.INSERT)
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "NOVELFILE_UPLOADDATE",updatable = false)
   private Date novelFileUploadUpdate;  // 소설 작성 시간
   @Generated(GenerationTime.INSERT)
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "NOVELFILE_UPDATEDATE")
   private Date novelFileUpdateDate;  // 소설 수정시간

    public void updateNovelFileFilePath(String novelFileFilePath) { this.novelFileFilePath = novelFileFilePath; }

    public void updateNovelFileOriginalFileName(String novelFileOriginalUUID) { this.novelFileOriginalUUID = novelFileOriginalUUID; }

    public void updateNovelFileFileName(String novelFileFileName) { this.novelFileFileName = novelFileFileName; }


    public void updateNovelFileUpdateDate() { this.novelFileUpdateDate = new Date();  }

    @Builder
   public NovelFileVO(Long novelFileNumber, SubNovelVO subNovelVO, UserVO userVO, NovelVO novelVO, String novelFileFilePath, String novelFileOriginalUUID, String novelFileFileName, String novelFileUploadUpdate, String novelFileUpdateDate) {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.novelFileNumber = novelFileNumber;
        this.subNovelVO = subNovelVO;
        this.userVO = userVO;
        this.novelVO = novelVO;
        this.novelFileFilePath = novelFileFilePath;
        this.novelFileOriginalUUID = novelFileOriginalUUID;
        this.novelFileFileName = novelFileFileName;

       try {
           if(novelFileUploadUpdate != null) { this.novelFileUploadUpdate = sdf.parse(novelFileUploadUpdate); }
           if(novelFileUpdateDate != null) { this.novelFileUpdateDate = sdf.parse(novelFileUpdateDate); }
       } catch (ParseException e) { e.printStackTrace(); }

   }
}
