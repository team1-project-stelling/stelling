package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.NovelVO;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NovelRepository extends JpaRepository<NovelVO, Long> {

    /*SELECT COUNT(NOVEL_NUMBER) FROM TBL_NOVEL;*/
    @Query( value = "SELECT COUNT(NOVEL_NUMBER) FROM TBL_NOVEL", nativeQuery = true)
    int findByIdTotal();
    Page<NovelVO> findByNovelHashtagContaining(String keyword, Pageable pageable);
    Page<NovelVO> findAll(Pageable pageable);
//    Page<NovelVO> findAll(Pageable pageable);

}
