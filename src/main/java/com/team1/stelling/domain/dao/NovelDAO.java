package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.criteria.NovelRankingCriteria;
import com.team1.stelling.domain.dto.NovelRankingDTO;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.mapper.NovelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class NovelDAO {
    private final  NovelMapper novelMapper;
    public List<NovelRankingDTO> rankingSearch(NovelRankingCriteria novelRankingCriteria){return  novelMapper.rankingSearch(novelRankingCriteria);}

}
