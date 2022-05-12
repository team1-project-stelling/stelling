package com.team1.stelling.domain.vo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="TBL_NOVELFILE")
@SequenceGenerator(name ="NOVELFILE_SEQ" , allocationSize = 1)
@Getter
@ToString(of = {"novelFileNumber","novelFileFilePath","novelFileOriginalFileName","novelFileFileName","novelFileUploadUpdate", "novelFileUpdateDate"})
@NoArgsConstructor
public class NovelFileVO {


   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOVELFILE_SEQ")
   @Value("NOVELFILE_NUMBER")
   private Long novelFileNumber; //*파일번호, 소설원고*//*

   @ManyToOne
   @JoinColumn(name = "SUBNOVEL_NUMBER")
   private SubNovelVO subNovelVO; //* FK *//*
   @ManyToOne
   @JoinColumn(name = "USER_NUMBER")
   private UserVO userVO;  // 유저번호 FK

   @ManyToOne
   @JoinColumn(name = "NOVEL_NUMBER")
   private NovelVO novelVO;

    @Column(name = "NOVELFILE_FILEPATH")
   private String novelFileFilePath; // 소설 파일 경로
   @Column(name ="NOVELFILE_ORIGINFILENAME")
   private String novelFileOriginalFileName; // 소설 원본 파일 이름
   @Column(name ="NOVELFILE_FILENAME")
   private String novelFileFileName;  // 소설 파일 이름
   @Column(name = "NOVELFILE_UPLOADDATE ")
   private Date novelFileUploadUpdate;  // 소설 작성 시간
   @Column(name = "NOVELFILE_UPDATEDATE ")
   private Date novelFileUpdateDate;  // 소설 수정시간

   @Builder
   public NovelFileVO(Long novelFileNumber, SubNovelVO subNovelVO, UserVO userVO, NovelVO novelVO, String novelFileFilePath, String novelFileOriginalFileName, String novelFileFileName, Date novelFileUploadUpdate, Date novelFileUpdateDate) {
        this.novelFileNumber = novelFileNumber;
        this.subNovelVO = subNovelVO;
        this.userVO = userVO;
        this.novelVO = novelVO;
        this.novelFileFilePath = novelFileFilePath;
        this.novelFileOriginalFileName = novelFileOriginalFileName;
        this.novelFileFileName = novelFileFileName;
        this.novelFileUploadUpdate = novelFileUploadUpdate;
        this.novelFileUpdateDate = novelFileUpdateDate;
    }
}
