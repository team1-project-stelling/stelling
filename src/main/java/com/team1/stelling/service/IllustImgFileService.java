package com.team1.stelling.service;

import com.team1.stelling.domain.repository.IllustImgFileRepository;
import com.team1.stelling.domain.repository.NovelRepository;
import com.team1.stelling.domain.vo.IllustImgFileVO;
import com.team1.stelling.domain.vo.NovelVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IllustImgFileService {
    private  final IllustImgFileRepository illustImgFileRepository;


    public List<IllustImgFileVO> getList(){
        return illustImgFileRepository.findAll();
    }
    public IllustImgFileVO get(Long illustImgFileBno){ return illustImgFileRepository.findById(illustImgFileBno).get();}
    public void register(IllustImgFileVO vo){ illustImgFileRepository.save(vo);}
    public void modify(IllustImgFileVO vo){
        vo.updateIllustImgFileUpdateDate();
        illustImgFileRepository.save(vo);
    }
}
