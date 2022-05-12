package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.vo.BuyChapterVO;
import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.mapper.IllustProfileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class IllustProfileDAO {
    private final IllustProfileMapper illustProfileMapper;

    public IllustProfileVO get(Long illustProfileNumber) {return illustProfileMapper.get(illustProfileNumber);}
    public void register(IllustProfileVO illustProfileVO) {illustProfileMapper.insert(illustProfileVO);}
    public void modify(IllustProfileVO illustProfileVO) {illustProfileMapper.update(illustProfileVO);}
}
