package com.team1.stelling.domain.vo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="TBL_ILLUSTIMGFILE")
@SequenceGenerator(name ="ILLUSTIMGFILE_SEQ" , allocationSize = 1)
@Getter
@ToString(of = {"illustImgFileNumber","illustImgFileFilePath","illustImgFileOriginFileName","illustImgFileFileName","illustImgFileUploadDate","illustImgFileUpdateDate"})
@NoArgsConstructor
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
   @Column(name = "ILLUSTIMGFILE_UPLOADDATE")
   private Date illustImgFileUploadDate; // 일러스트 등록 시간
   @Column(name = "ILLUSTIMGFILE_UPDATEDATE")
   private Date illustImgFileUpdateDate; // 일러스트 수정시간

   @Builder
   public IllustImgFileVO(Long illustImgFileNumber, IllustVO illustVO, UserVO userVO, String illustImgFileFilePath, String illustImgFileOriginFileName, String illustImgFileFileName, Date illustImgFileUploadDate, Date illustImgFileUpdateDate) {
        this.illustImgFileNumber = illustImgFileNumber;
        this.illustVO = illustVO;
        this.userVO = userVO;
        this.illustImgFileFilePath = illustImgFileFilePath;
        this.illustImgFileOriginFileName = illustImgFileOriginFileName;
        this.illustImgFileFileName = illustImgFileFileName;
        this.illustImgFileUploadDate = illustImgFileUploadDate;
        this.illustImgFileUpdateDate = illustImgFileUpdateDate;
    }
}
