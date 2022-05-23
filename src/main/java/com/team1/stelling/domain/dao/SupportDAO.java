package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.InquiryVO;
import com.team1.stelling.domain.vo.SupportVO;
import com.team1.stelling.mapper.SupportMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SupportDAO {
    private final SupportMapper supportMapper;

    public SupportVO get(Long supportNumber) {return supportMapper.get(supportNumber);}
    public void register(SupportVO supportVO) {supportMapper.insert(supportVO);}
    public List<SupportVO> getSupportListWithNovelNumber(Long novelNumber){return supportMapper.getSupportListWithNovelNumber(novelNumber);}
}
