package com.team1.stelling.mapper;

import com.team1.stelling.domain.criteria.NovelRankingCriteria;
import com.team1.stelling.domain.dto.NovelRankingDTO;
import com.team1.stelling.domain.vo.NovelVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NovelMapper {
    public List<NovelRankingDTO> rankingSearch(NovelRankingCriteria novelRankingCriteria);
}
