package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.MyPickVO;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.domain.vo.RecentViewVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface RecentViewRepository extends JpaRepository<RecentViewVO, Long> {
    Page<RecentViewVO> findByUserVO_UserNumber(Long userNumber, Pageable pageable);
    Page<RecentViewVO> findByUserVO_UserNumberAndNovelVO_NovelHashtagContaining(Long userNumber, String keyword, Pageable pageable);
    @Transactional
    int deleteByRecentViewNumber(Long recentViewNum);
}
