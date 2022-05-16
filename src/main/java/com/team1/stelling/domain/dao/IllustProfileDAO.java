package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.dto.IllustProfileDTO;
import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.mapper.IllustProfileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class IllustProfileDAO {
    private final IllustProfileMapper illustProfileMapper;

    public IllustProfileDTO get(Long userNumber) {return illustProfileMapper.get(userNumber);}
    public void register(IllustProfileVO illustProfileVO) {illustProfileMapper.insert(illustProfileVO);}
}
