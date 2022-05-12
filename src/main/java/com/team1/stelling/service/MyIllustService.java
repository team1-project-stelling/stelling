package com.team1.stelling.service;

import com.team1.stelling.domain.dao.MyIllustDAO;
import com.team1.stelling.domain.vo.InquiryVO;
import com.team1.stelling.domain.vo.MyIllustVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyIllustService{
    private final MyIllustDAO myIllustDAO;

    public MyIllustVO get(Long myIllustNumber) {return myIllustDAO.get(myIllustNumber);}
    public void register(MyIllustVO myIllustVO) {myIllustDAO.register(myIllustVO);}
    public void modify(MyIllustVO myIllustVO) {myIllustDAO.modify(myIllustVO);}
}
