package com.team1.stelling.mapper;

import com.team1.stelling.domain.dto.NewIllustDTO;
import com.team1.stelling.domain.dto.NovelDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    //소설 신작 리스트
    public List<NovelDTO> getNewNovelList();
    
    //일러스트 신작 리스트
    public List<NewIllustDTO> getNewIllustList();
}
