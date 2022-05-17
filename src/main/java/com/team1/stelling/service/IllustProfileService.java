package com.team1.stelling.service;


import com.team1.stelling.domain.dao.IllustProfileDAO;
import com.team1.stelling.domain.dto.IllustProfileDTO;

import com.team1.stelling.domain.vo.IllustProfileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IllustProfileService{

    private final IllustProfileDAO illustProfileDAO;

    public IllustProfileDTO get(Long userNumber) {return illustProfileDAO.get(userNumber);}
    public void register(IllustProfileVO illustProfileVO) {illustProfileDAO.register(illustProfileVO);}
}
