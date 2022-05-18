package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.RecentViewVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecentViewRepository extends JpaRepository<RecentViewVO, Long> {
    Page<RecentViewVO> findByUserVO_UserNumber(Long userNumber, Pageable pageable);
}
