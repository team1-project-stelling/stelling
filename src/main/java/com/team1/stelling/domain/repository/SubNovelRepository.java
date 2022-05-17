package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.SubNovelVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubNovelRepository extends JpaRepository<SubNovelVO, Long> {
    List<SubNovelVO> findByNovelVO_NovelNumber(Long novelNumber);

    List<SubNovelVO> findAllByNovelVO_NovelNumberOrderBySubNovelNumber(Long novelNumber);

}
