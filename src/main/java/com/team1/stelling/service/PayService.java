package com.team1.stelling.service;

import com.team1.stelling.domain.dao.PayDAO;
import com.team1.stelling.domain.vo.PayVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayService{
    private final PayDAO payDAO;

}
