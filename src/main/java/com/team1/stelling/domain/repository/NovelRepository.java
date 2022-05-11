package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.NovelVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovelRepository extends JpaRepository<NovelVO, Long> {
}
