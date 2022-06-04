package com.team1.stelling.service;

import com.team1.stelling.domain.repository.NovelFileRepository;
import com.team1.stelling.domain.vo.NovelFileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NovelFileService {
    private final  NovelFileRepository novelFileRepository;
    public NovelFileVO get(Long nvfNo){return novelFileRepository.findById(nvfNo).get();}
    public List<NovelFileVO> getList() {return novelFileRepository.findAll();}
    public void register(NovelFileVO vo) {novelFileRepository.save(vo);}
    public void modify(NovelFileVO vo) {
        vo.updateNovelFileUpdateDate();
        novelFileRepository.save(vo);
    }
    public NovelFileVO getFilePathBySubNum(Long subNum){return novelFileRepository.findBySubNovelVO_SubNovelNumberOrderByNovelFileNumber(subNum);}

}
