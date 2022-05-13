package com.team1.stelling.service;

import com.team1.stelling.domain.dao.BuyChapterDAO;
import com.team1.stelling.domain.vo.BuyChapterVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

    @Service
    public interface BuyChapterService {

        public BuyChapterVO get(Long userNumber);
    }
