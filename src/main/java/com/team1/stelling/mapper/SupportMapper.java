package com.team1.stelling.mapper;

import com.team1.stelling.domain.dto.SupportDTO;
import com.team1.stelling.domain.vo.Criteria;
import com.team1.stelling.domain.vo.PayDTO;
import com.team1.stelling.domain.vo.SupportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupportMapper {
    //등록
    public int insert(SupportVO supportVO);

    //조회
    public SupportVO read(Long supportNumber);
    
    //후원 내역
    public List<SupportVO> getSuppotList(Criteria criteria, Long supportSponser);
    
    //검색한 결과의 총 개수
    public int getSearchSupportTotal(Criteria criteria);

    //후원한 코인 총 개수
    public SupportDTO getSupportCoinTotal(Long supportSponser);
    public SupportVO get(Long supportNumber);

    public List<SupportVO> getSupportListWithNovelNumber(Long novelNumber);
}
