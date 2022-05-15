package com.team1.stelling.service;

import com.team1.stelling.domain.dto.NovelCategoryDTO;
import com.team1.stelling.domain.repository.NovelRepository;
import com.team1.stelling.domain.vo.MyPickVO;
import com.team1.stelling.domain.vo.NovelVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.cglib.core.internal.Function;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class NovelService {
    private final NovelRepository novelRepository;
//    private final NovelSearchRepository novelSearchRepository;
    private final ModelMapper modelMapper;

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
    public Page<NovelCategoryDTO> search(String keyword, Pageable pageable) {
        return  novelRepository.findByNovelHashtagContaining(keyword,pageable).map(objectEntity -> modelMapper.map(objectEntity, NovelCategoryDTO.class));
    }
    /* 페이징처리 전체조회*/
    @Transactional
    public Page<NovelCategoryDTO> getList(Pageable pageable){
//        novelRepository.findAll(pageable).map(objectEntity -> modelMapper.map(objectEntity, NovelCategoryDTO.class));
        return  novelRepository.findAll(pageable).map(objectEntity -> modelMapper.map(objectEntity, NovelCategoryDTO.class));
    }

}