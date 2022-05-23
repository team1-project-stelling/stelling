package com.team1.stelling.service;

import com.team1.stelling.domain.repository.InquiryRepository;
import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.InquiryVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InquiryService{
    private final InquiryRepository inquiryRepository;

    public void register(InquiryVO inquiryVO) { inquiryRepository.save(inquiryVO);}
    public Page<InquiryVO> getPageList(Pageable pageable, Long userNumber){return inquiryRepository.findByUserVO_UserNumber(userNumber, pageable);}
    public InquiryVO get(Long inquiryNumber){return inquiryRepository.findById(inquiryNumber).orElse(new InquiryVO());}
}
