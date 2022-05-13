package com.team1.stelling.service;

import com.team1.stelling.domain.repository.NovelImgFileRepository;
import com.team1.stelling.domain.vo.NovelImgFileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NovelImgFileService {
    private final NovelImgFileRepository novelImgFileRepository;

    public NovelImgFileVO get(Long nifNo) {return novelImgFileRepository.findById(nifNo).get(); }
    public List<NovelImgFileVO> getList() {return  novelImgFileRepository.findAll();}
    public void register(NovelImgFileVO vo){novelImgFileRepository.save(vo); }
    public void modify(NovelImgFileVO vo){
        vo.updateNovelImgFileUpdateDate();
        novelImgFileRepository.save(vo);
    }


}
