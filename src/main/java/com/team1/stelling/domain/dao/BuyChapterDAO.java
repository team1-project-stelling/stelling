package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.vo.BuyChapterVO;
import com.team1.stelling.mapper.BuyChapterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BuyChapterDAO {
    private final BuyChapterMapper buyChapterMapper;

    public BuyChapterVO get(Long userNumber) {return buyChapterMapper.get(userNumber);}
    public void register(BuyChapterVO buyChapterVO) {buyChapterMapper.insert(buyChapterVO);}

}
