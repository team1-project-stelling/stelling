package com.team1.stelling.service;

import com.team1.stelling.domain.dao.PayDAO;
import com.team1.stelling.domain.vo.PayVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayService{
    private final PayDAO payDAO;


//    public PayVO get(Long payNumber) {return payDAO.get(payNumber);}
    public List<PayVO> getList(Long userNumber) {return payDAO.getList(userNumber);}
    public void register(PayVO payVO) {payDAO.register(payVO);}
}
