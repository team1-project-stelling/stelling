package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.SubNovelVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubNovelRepository extends JpaRepository<SubNovelVO, Long> {
  Page<SubNovelVO> findAllByNovelVO_NovelNumber(Long novelNumber,Pageable pageable);
  List<SubNovelVO> findAllByNovelVO_NovelNumberOrderBySubNovelUploadDate(Long novelNumber);
//  void deleteBySubNovelNumber(Long subnovelNumber);
  void deleteSubNovelVOBySubNovelNumber(Long subNovelNumber);


}
