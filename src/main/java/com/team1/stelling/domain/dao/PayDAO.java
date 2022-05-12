package com.team1.stelling.domain.dao;

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

    public int register(PayVO payVO){
        log.info("pay register...." + payVO);
        return payMapper.insert(payVO);
    }
}
