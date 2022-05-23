package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.InquiryVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<InquiryVO, Long> {
    InquiryVO findByUserVO_UserNumber(Long userNumber);
}
