package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.dto.NewIllustDTO;
import com.team1.stelling.domain.dto.NovelDTO;
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

}
