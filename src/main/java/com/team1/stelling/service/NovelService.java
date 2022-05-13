package com.team1.stelling.service;

import com.team1.stelling.domain.repository.NovelRepository;
import com.team1.stelling.domain.vo.NovelVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NovelService {
    private final NovelRepository novelRepository;

    public NovelVO get(Long nNO){ return novelRepository.findById(nNO).orElseGet(null);}
    public List<NovelVO> getList(){return novelRepository.findAll();}
    public void register(NovelVO novelVO){ novelRepository.save(novelVO);}
    public void modify(NovelVO novelVO) {
        novelVO.updateNovelUpdateDate();
        novelRepository.save(novelVO);
    }

}
