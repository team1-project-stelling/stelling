package com.team1.stelling.service;

import com.team1.stelling.domain.repository.IllustRepository;
import com.team1.stelling.domain.vo.IllustVO;
import com.team1.stelling.domain.vo.SubNovelVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IllustService {
    private final IllustRepository illustRepository;
    private final ModelMapper modelMapper;

    public IllustVO get(Long illustBno){
        return illustRepository.findById(illustBno).get();
    }
    public List<IllustVO> getList (){return illustRepository.findAll();}
    public void register (IllustVO vo){illustRepository.save(vo);}
    public void modify(IllustVO vo){
        vo.updateIllustUpdateDate();
        illustRepository.save(vo);
    }
    public int getTotal(){return illustRepository.findByUserNumberTotal(1L);}

    public List<IllustVO> getList(Long userNumber){return illustRepository.findByUserVO_UserNumber(userNumber);}
    @Transactional
    public Page<IllustVO> getList(Pageable pageable){
        return  illustRepository.findAll(pageable).map(objectEntity -> modelMapper.map(objectEntity, IllustVO.class));
    }
    
}