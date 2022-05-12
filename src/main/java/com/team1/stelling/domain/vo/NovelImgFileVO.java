package com.team1.stelling.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="TBL_NOVELIMGFILE")
@SequenceGenerator(name ="NOVELIMGFILE_SEQ" , allocationSize = 1)
@Getter
@ToString(of = {"novelImgFileNumber","novelImgFileFilePath","novelImgFileOriginFileName","novelImgFileFileName","novelImgFileUploadDate","novelImgFileUpdateDate"})
@NoArgsConstructor
public class NovelImgFileVO {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOVELIMGFILE_SEQ")
   @Column(name = "NOVELIMGFILE_NUMBER")
   private Long novelImgFileNumber; // 소설파일 번호

   @ManyToOne
   @JoinColumn(name = "NOVEL_NUMBER")
   private NovelVO novelVO;     /* 소설NUM FK*/
   @ManyToOne
   @JoinColumn(name = "USER_NUMBER")
   private UserVO userVO; // userNum Fk
   @Column(name = "NOVELIMGFILE_FILEPATH")
   private String novelImgFileFilePath;
   @Column(name ="NOVELIMGFILE_ORIGINFILENAME")
   private String novelImgFileOriginFileName;
   @Column(name = "NOVELIMGFILE_FILENAME")
   private String novelImgFileFileName;
   @Column(name = "NOVELIMGFILE_UPLOADDATE")
   private Date novelImgFileUploadDate;
   @Column(name ="NOVELIMGFILE_UPDATEDATE")
   private Date novelImgFileUpdateDate;

   @Builder
   public NovelImgFileVO(Long novelImgFileNumber, NovelVO novelVO, UserVO userVO, String novelImgFileFilePath, String novelImgFileOriginFileName, String novelImgFileFileName, Date novelImgFileUploadDate, Date novelImgFileUpdateDate) {
        this.novelImgFileNumber = novelImgFileNumber;
        this.novelVO = novelVO;
        this.userVO = userVO;
        this.novelImgFileFilePath = novelImgFileFilePath;
        this.novelImgFileOriginFileName = novelImgFileOriginFileName;
        this.novelImgFileFileName = novelImgFileFileName;
        this.novelImgFileUploadDate = novelImgFileUploadDate;
        this.novelImgFileUpdateDate = novelImgFileUpdateDate;
    }
}
