package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.InquiryVO;
import com.team1.stelling.domain.vo.PayVO;
import com.team1.stelling.mapper.PayMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PayDAO {
    private final PayMapper payMapper;

    public PayVO get(Long payNumber) {return payMapper.get(payNumber);}
    public void register(PayVO payVO) {payMapper.insert(payVO);}
}
