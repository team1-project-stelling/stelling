package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.InquiryVO;
import com.team1.stelling.domain.vo.PayDTO;
import com.team1.stelling.domain.vo.PayVO;
import com.team1.stelling.mapper.PayMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PayDAO {
    private final PayMapper payMapper;

//    public PayVO get(Long payNumber) {return payMapper.get(payNumber);}
    //결제 내역
    public List<PayVO> getList(Long userNumber) {return payMapper.getList(userNumber);}
    //총 결제 금액
    public PayDTO getTotal(Long userNumber) {return payMapper.getTotal(userNumber);}
//    public void register(Long userNumber, Long payCharge, Long payCoinCount) {payMapper.insert(userNumber, payCharge, payCoinCount);}
    public void register(PayVO payVO) {payMapper.insert(payVO);}
}
