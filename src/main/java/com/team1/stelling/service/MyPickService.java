package com.team1.stelling.service;

import com.team1.stelling.domain.dto.MyPickDTO;
import com.team1.stelling.domain.repository.MyPickRepository;
import com.team1.stelling.domain.vo.MyPickVO;
import com.team1.stelling.mapper.CustomModelMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyPickService{
    private final MyPickRepository myPickRepository;
    private final ModelMapper customModelMapper;
    public MyPickVO get(Long myPickNumber) {

        MyPickVO myPickVO = myPickRepository.findById(myPickNumber).orElse(null);
        if(Objects.isNull(myPickVO)) {
            // null일 때 처리 코드
        }
        return myPickVO;
    }
    public void register(MyPickDTO myPickDTO) {

        MyPickVO myPickVO = customModelMapper.map(myPickDTO, MyPickVO.class);
        myPickRepository.save(myPickVO);
    }
    public void register(MyPickVO myPickVO) {myPickRepository.save(myPickVO);}

    public void removeMyPick(Long pickNum){myPickRepository.deleteById(pickNum);}


    public MyPickVO getByNovelNumAndUserNum(Long novelNum, Long userNum){return myPickRepository.getByNovelVO_NovelNumberAndUserVOUserNumber(novelNum, userNum);}
/*    public MyPickVO get(Long myPickNumber) {return myPickRepository.findById(myPickNumber).get();}
    public void register(MyPickVO myPickVO) {myPickRepository.save(myPickVO);}
    public MyPickVO get(Long myPickNumber) {return myPickDAO.get(myPickNumber);}
    public void register(MyPickVO myPickVO) {myPickDAO.register(myPickVO);}
    public void modify(MyPickVO myPickVO) {myPickDAO.modify(myPickVO);}*/
}
