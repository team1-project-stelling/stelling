package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.vo.MyPickVO;
import com.team1.stelling.mapper.MyPickMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MyPickDAO {
    private final MyPickMapper myPickMapper;

    public int register(MyPickVO myPickVO){
        log.info("myPick register...." + myPickVO);
        return myPickMapper.insert(myPickVO);
    }
}
