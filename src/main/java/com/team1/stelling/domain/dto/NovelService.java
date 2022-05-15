package com.team1.stelling.domain.dto;

import com.team1.stelling.domain.repository.NovelRepository;
import com.team1.stelling.domain.vo.NovelVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public int getTotal(){return novelRepository.findByIdTotal();}

    /* search */
    @Transactional
    public Page<NovelVO> search(String keyword, Pageable pageable) {
        Page<NovelVO> novelList = novelRepository.findByNovelHashtagContaining(keyword, pageable);
        return novelList;
    }
    /* 페이징처리 전체조회*/
    @Transactional
    public Page<NovelVO> getList(Pageable pageable){return novelRepository.findAll(pageable);}

}
