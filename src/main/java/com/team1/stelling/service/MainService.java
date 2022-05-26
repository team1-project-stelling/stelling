package com.team1.stelling.service;

import com.team1.stelling.domain.dao.MainDAO;
import com.team1.stelling.domain.dto.NewIllustDTO;
import com.team1.stelling.domain.dto.NovelDTO;
import com.team1.stelling.domain.vo.NovelVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {
    private final MainDAO mainDAO;

    //소설 신작 리스트
    public List<NovelDTO> getNewNovelList(){return mainDAO.getNewNovelList();}

    //일러스트 신작 리스트
    public List<NewIllustDTO> getNewIllustList(){return mainDAO.getNewIllustList();}

}
