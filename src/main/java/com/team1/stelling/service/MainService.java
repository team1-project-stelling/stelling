package com.team1.stelling.service;

import com.team1.stelling.domain.criteria.MainCriteria;
import com.team1.stelling.domain.dao.MainDAO;
import com.team1.stelling.domain.dto.NewIllustDTO;
import com.team1.stelling.domain.dto.NovelDTO;
import com.team1.stelling.domain.dto.NovelRankingDTO;
import com.team1.stelling.domain.vo.Criteria;
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

    //완결 소설 리스트
    public List<NovelDTO> getEndNovelList(){return mainDAO.getEndNovelList();}

    //실시간 조회수 리스트
    public List<NovelRankingDTO> getViewCountSearch(MainCriteria mainCriteria){return mainDAO.getViewCountSearch(mainCriteria);}

    //실시간 좋아요 리스트
    public List<NovelRankingDTO> getLikeCountSearch(MainCriteria mainCriteria){return mainDAO.getLikeCountSearch(mainCriteria);}

    //실시간 회차수 리스트
    public List<NovelRankingDTO> getRoundCountSearch(MainCriteria mainCriteria){return mainDAO.getRoundCountSearch(mainCriteria);}

    //배너 이미지
    public List<NovelDTO> getBannerImg(){return mainDAO.getBannerImg();}
}
