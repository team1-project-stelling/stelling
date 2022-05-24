package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.InquiryVO;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.domain.vo.UserVO;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface NovelRepository extends JpaRepository<NovelVO, Long> {

    /*SELECT COUNT(NOVEL_NUMBER) FROM TBL_NOVEL;*/
    @Query( value = "SELECT COUNT(NOVEL_NUMBER) FROM TBL_NOVEL", nativeQuery = true)
    int findByIdTotal();
    Page<NovelVO> findByNovelHashtagContaining(String keyword, Pageable pageable);
    Page<NovelVO> findAll(Pageable pageable);
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
}
