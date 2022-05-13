package com.team1.stelling.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "NOVELIMGFILE_UPLOADDATE",updatable = false)
   private Date novelImgFileUploadDate;
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
   @Column(name ="NOVELIMGFILE_UPDATEDATE")
   private Date novelImgFileUpdateDate;

    public void updateNovelImgFileFilePath(String novelImgFileFilePath) { this.novelImgFileFilePath = novelImgFileFilePath; }
    public void updateNovelImgFileOriginFileName(String novelImgFileOriginFileName) { this.novelImgFileOriginFileName = novelImgFileOriginFileName; }
    public void updateNovelImgFileFileName(String novelImgFileFileName) { this.novelImgFileFileName = novelImgFileFileName; }
    public void updateNovelImgFileUpdateDate() { this.novelImgFileUpdateDate = new Date(); }

    @Builder
   public NovelImgFileVO(Long novelImgFileNumber, NovelVO novelVO, UserVO userVO, String novelImgFileFilePath, String novelImgFileOriginFileName, String novelImgFileFileName, String novelImgFileUploadDate, String novelImgFileUpdateDate) {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.novelImgFileNumber = novelImgFileNumber;
        this.novelVO = novelVO;
        this.userVO = userVO;
        this.novelImgFileFilePath = novelImgFileFilePath;
        this.novelImgFileOriginFileName = novelImgFileOriginFileName;
        this.novelImgFileFileName = novelImgFileFileName;
       try {
           if(novelImgFileUploadDate != null) { this.novelImgFileUploadDate = sdf.parse(novelImgFileUploadDate); }
           if(novelImgFileUpdateDate != null) { this.novelImgFileUpdateDate = sdf.parse(novelImgFileUpdateDate); }
       } catch (ParseException e) { e.printStackTrace(); }
   }
}
