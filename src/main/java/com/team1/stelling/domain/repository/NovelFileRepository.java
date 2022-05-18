package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.NovelFileVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NovelFileRepository extends JpaRepository<NovelFileVO, Long> {
    NovelFileVO findBySubNovelVO_SubNovelNumberOrderByNovelFileNumber(Long subNovelNumber);
}
