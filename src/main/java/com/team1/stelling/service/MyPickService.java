package com.team1.stelling.service;

import com.team1.stelling.domain.repository.MyPickRepository;
import com.team1.stelling.domain.vo.MyPickVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyPickService{
    private final MyPickRepository myPickRepository;

    public MyPickVO get(Long myPickNumber) {return myPickRepository.findById(myPickNumber).get();}
    public void register(MyPickVO myPickVO) {myPickRepository.save(myPickVO);}
/*    public MyPickVO get(Long myPickNumber) {return myPickDAO.get(myPickNumber);}
    public void register(MyPickVO myPickVO) {myPickDAO.register(myPickVO);}
    public void modify(MyPickVO myPickVO) {myPickDAO.modify(myPickVO);}*/
}
