package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.ReplyVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyVO, Long> {
    List<ReplyVO> findAllBySubNovelVO_SubNovelNumberOrderByReplyNumber(Long subNovelNUm);

    Page<ReplyVO> findAllByNovelVO_NovelNumber(Long novelNum, Pageable pageable);
    Page<ReplyVO> findAllBySubNovelVO_SubNovelNumber(Long subNum, Pageable pageable);
    List<ReplyVO> findAllByNovelVO_NovelNumber(Long novelNum);

    //노벨넘버로 댓글 추천순
//    List<ReplyVO> findAllByNovelVO_NovelNumberOrderByReplyUpDesc(Long novelNum);




}
