package com.team1.stelling.service;

import com.team1.stelling.domain.dto.IllustProfileRegisterDTO;
import com.team1.stelling.domain.repository.IllustProfileRepository;
import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.IllustVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IllustProfileService{
    private final IllustProfileRepository illustProfileRepository;

    public IllustProfileVO get(Long illustProfileBno){
        return illustProfileRepository.findById(illustProfileBno).get();
    }
    public List<IllustProfileVO> getList (){return illustProfileRepository.findAll();}
    public void register (IllustProfileRegisterDTO registerDTO){
        illustProfileRepository.save(registerDTO.toEntity()).getUserVO();
    }

    public void modify(IllustProfileVO vo){
        illustProfileRepository.save(vo);
    }
}
