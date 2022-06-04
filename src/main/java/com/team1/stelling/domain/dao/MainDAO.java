package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.criteria.MainCriteria;
import com.team1.stelling.domain.dto.NewIllustDTO;
import com.team1.stelling.domain.dto.NovelDTO;
import com.team1.stelling.domain.dto.NovelRankingDTO;
import com.team1.stelling.domain.vo.Criteria;
import com.team1.stelling.mapper.MainMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MainDAO {
    private final MainMapper mainMapper;

    //소설 신작 리스트
    public List<NovelDTO> getNewNovelList(){return mainMapper.getNewNovelList();}

    //일러스트 신작 리스트
    public List<NewIllustDTO> getNewIllustList(){return mainMapper.getNewIllustList();}

    //완결 소설 리스트
    public List<NovelDTO> getEndNovelList(){return mainMapper.getEndNovelList();}

    //실시간 조회수 리스트
    public List<NovelRankingDTO> getViewCountSearch(MainCriteria mainCriteria){return mainMapper.getViewCountSearch(mainCriteria);}

    //실시간 좋아요 리스트
    public List<NovelRankingDTO> getLikeCountSearch(MainCriteria mainCriteria){return mainMapper.getLikeCountSearch(mainCriteria);}

    //실시간 회차순 리스트
    public List<NovelRankingDTO> getRoundCountSearch(MainCriteria mainCriteria){return mainMapper.getRoundCountSearch(mainCriteria);}

    //배너 이미지
    public List<NovelDTO> getBannerImg(){return mainMapper.getBannerImg();}
}
