package com.team1.stelling.service;

import com.team1.stelling.domain.vo.PayVO;
import org.springframework.stereotype.Service;

@Service
public interface PayService {
    public boolean register(PayVO payVO);
}
