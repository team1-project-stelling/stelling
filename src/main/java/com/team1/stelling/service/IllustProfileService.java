package com.team1.stelling.service;

import com.team1.stelling.domain.dao.IllustProfileDAO;
import com.team1.stelling.domain.vo.IllustProfileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class IllustProfileService{
    private final IllustProfileDAO illustProfileDAO;

    public IllustProfileVO get(Long illustProfileNumber) {return illustProfileDAO.get(illustProfileNumber);}
    public void register(IllustProfileVO illustProfileVO) {illustProfileDAO.register(illustProfileVO);}
    public void modify(IllustProfileVO illustProfileVO) {illustProfileDAO.modify(illustProfileVO);}

}
