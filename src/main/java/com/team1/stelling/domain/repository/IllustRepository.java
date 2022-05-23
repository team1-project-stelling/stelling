package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.IllustVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IllustRepository extends JpaRepository<IllustVO, Long> {
    @Query(value = "SELECT COUNT(USER_NUMBER) FROM TBL_ILLUST", nativeQuery = true)
    int findByUserNumberTotal(Long userNumber);


    Page<IllustVO> findByUserVO_UserNumber(Pageable pageable, Long userNumber);

    List<IllustVO> findByUserVO_UserNumber(Long userNumber);

}
