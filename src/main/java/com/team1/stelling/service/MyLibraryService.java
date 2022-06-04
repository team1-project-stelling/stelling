package com.team1.stelling.service;

import com.team1.stelling.domain.repository.MyPickRepository;
import com.team1.stelling.domain.vo.MyPickVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyLibraryService {
    private final MyPickRepository myPickRepository;

    public Page<MyPickVO> getMyPickList(Long userNumber,Pageable pageable){return myPickRepository.findByUserVO_UserNumber(userNumber,pageable);}
    public Page<MyPickVO> getMyPickTagSearch(Long userNumber,String keyword,Pageable pageable){return myPickRepository.findByUserVO_UserNumberAndNovelVO_NovelHashtagContaining(userNumber,keyword,pageable);}
    public boolean remove(Long myPickNumber){return myPickRepository.deleteByMyPickNumber(myPickNumber) == 1;}
}
