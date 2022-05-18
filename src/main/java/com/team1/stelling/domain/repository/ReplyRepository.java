package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.ReplyVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyVO, Long> {
    List<ReplyVO> findAllBySubNovelVO_SubNovelNumberOrderByReplyNumber(Long subNovelNUm);


}
