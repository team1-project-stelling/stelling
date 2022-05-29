package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.InquiryVO;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.domain.vo.SubNovelVO;
import com.team1.stelling.domain.vo.UserVO;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

public interface NovelRepository extends JpaRepository<NovelVO, Long> {

    /*SELECT COUNT(NOVEL_NUMBER) FROM TBL_NOVEL;*/
    @Query( value = "SELECT COUNT(NOVEL_NUMBER) FROM TBL_NOVEL", nativeQuery = true)
    int findByIdTotal();
    Page<NovelVO> findByNovelHashtagContaining(String keyword, Pageable pageable);
    Page<NovelVO> findAll(Pageable pageable);
    //노벨리스트 최신순으로 가져오기
//    Page<NovelVO> findAll(Pageable pageable);
    Page<NovelVO>findByNovelStatus(int novelStatus, Pageable pageable);
    Page<NovelVO> findByNovelStatusAndNovelHashtagContaining(int novelStatus,String keyword, Pageable pageable);
    Page<NovelVO> findAllByNovelUploadDateBetween(Date start, Date end,Pageable pageable);
    Page<NovelVO> findAllByNovelUploadDateBetweenAndNovelHashtagContaining(Date start, Date end,String keyword,Pageable pageable);

    // TOP 50
//    List<NovelVO> findTop50ByOrderByNovelLikeCountTotalDesc();
    List<NovelVO> findTop50ByOrderByNovelLikeCountTotalDesc();

//    List<NovelVO> findTop50ByNovelHashtagContainingOrderByNovelLikeCountTotalDesc(String keyword);

    Page<NovelVO> findByUserVO_userNumber(Long userNumber, Pageable pageable);
    List<NovelVO> findByUserVO(UserVO userVO);
    Page<NovelVO> findByNovelHashtagContainingOrNovelTitleContainingOrUserVO_UserNickNameContaining(String keyword1,String keyword2,String keyword3,Pageable pageable);
}
