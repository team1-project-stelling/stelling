package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.ReplyVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<ReplyVO, Long> {
}
