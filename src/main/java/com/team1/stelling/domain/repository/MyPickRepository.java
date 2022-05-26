package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.MyPickVO;
import com.team1.stelling.domain.vo.NovelVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MyPickRepository extends JpaRepository<MyPickVO, Long> {
    Page<MyPickVO> findByUserVO_UserNumberAndNovelVO_NovelHashtagContaining(Long userNumber,String keyword, Pageable pageable);
    Page<MyPickVO> findByUserVO_UserNumber(Long userNumber,Pageable pageable);

    MyPickVO getByNovelVO_NovelNumberAndUserVOUserNumber(Long novelNum, Long userNum);

    @Transactional
    int deleteByMyPickNumber(Long myPickNumber);

}
