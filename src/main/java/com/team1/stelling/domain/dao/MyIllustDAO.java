package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.InquiryVO;
import com.team1.stelling.domain.vo.MyIllustVO;
import com.team1.stelling.mapper.MyIllustMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MyIllustDAO {
    private final MyIllustMapper myIllustMapper;

    public MyIllustVO get(Long myIllustNumber) {return myIllustMapper.get(myIllustNumber);}
    public void register(MyIllustVO myIllustVO) {myIllustMapper.insert(myIllustVO);}
    public void modify(MyIllustVO myIllustVO) {myIllustMapper.update(myIllustVO);}
}
