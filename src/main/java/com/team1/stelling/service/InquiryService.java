package com.team1.stelling.service;

import com.team1.stelling.domain.dao.InquiryDAO;
import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.InquiryVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InquiryService{
    private final InquiryDAO inquiryDAO;

    public InquiryVO get(Long inquiryNumber) {return inquiryDAO.get(inquiryNumber);}
    public void register(InquiryVO inquiryVO) {inquiryDAO.register(inquiryVO);}
    public void modify(InquiryVO inquiryVO) {inquiryDAO.modify(inquiryVO);}
}
