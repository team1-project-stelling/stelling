package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.dto.IllustProfileDTO;
import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.IllustVO;
import com.team1.stelling.mapper.IllustProfileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class IllustProfileDAO {
    private final IllustProfileMapper illustProfileMapper;

    public IllustProfileDTO getProfile(Long userNumber) {return illustProfileMapper.getProfile(userNumber);}
    public void register(IllustProfileVO illustProfileVO) {illustProfileMapper.insert(illustProfileVO);}
    public List<IllustProfileDTO> list(){return illustProfileMapper.list();}
    public IllustProfileDTO checkProfile(Long userNumber) {return illustProfileMapper.checkProfile(userNumber);}
}
