package com.team1.stelling.service;

import com.team1.stelling.domain.vo.MyPickVO;
import org.springframework.stereotype.Service;

@Service
public interface MyPickService {
    public boolean register(MyPickVO myPickVO);
}
