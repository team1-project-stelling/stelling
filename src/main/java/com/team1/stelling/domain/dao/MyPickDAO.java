package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.InquiryVO;
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

    public MyPickVO get(Long myPickNumber) {return myPickMapper.get(myPickNumber);}
    public void register(MyPickVO myPickVO) {myPickMapper.insert(myPickVO);}
}
