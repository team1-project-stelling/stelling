package com.team1.stelling.service;

import com.team1.stelling.domain.repository.RecentViewRepository;
import com.team1.stelling.domain.vo.RecentViewVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecentViewService {
    private  final  RecentViewRepository recentViewRepository;

    public void register(RecentViewVO vo){ recentViewRepository.save(vo);}
    public RecentViewVO get(Long rvNo){return recentViewRepository.findById(rvNo).get();}
    public List<RecentViewVO> getList(){return recentViewRepository.findAll();}
}
