package com.team1.stelling.service;

import com.team1.stelling.domain.dao.InquiryDAO;
import com.team1.stelling.domain.repository.InquiryRepository;
import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.InquiryVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InquiryService{
    private final InquiryDAO inquiryDAO;
    private final InquiryRepository inquiryRepository;
    private final UserService userService;

    public void register(InquiryVO inquiryVO) { inquiryRepository.save(inquiryVO);}
    public void modify(InquiryVO inquiryVO) {inquiryDAO.modify(inquiryVO);}
    public InquiryVO get(Long inquiryNumber){return inquiryRepository.findById(inquiryNumber).orElse(new InquiryVO());}

}
