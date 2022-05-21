package com.team1.stelling.service;

import com.team1.stelling.domain.dao.SupportDAO;
import com.team1.stelling.domain.vo.SupportVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupportService{
    private final SupportDAO supportDAO;

    public SupportVO get(Long supportNumber) {return supportDAO.get(supportNumber);}
    public void register(SupportVO supportVO) {supportDAO.register(supportVO);}
    public List<SupportVO> getSupportListWithNovelNumber(Long novelNumber){return supportDAO.getSupportListWithNovelNumber(novelNumber);}

}
