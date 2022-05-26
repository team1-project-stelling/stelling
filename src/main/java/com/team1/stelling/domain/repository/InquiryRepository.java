package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.InquiryVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<InquiryVO, Long> {
    Page<InquiryVO> findByUserVO_UserNumber(Long userNum, Pageable pageable);

//public interface InquiryRepository extends JpaRepository<InquiryVO, Long> {
//    InquiryVO findByUserVO_UserNumber(Long userNumber);

}
