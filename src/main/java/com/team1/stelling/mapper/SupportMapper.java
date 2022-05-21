package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.SupportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupportMapper {
    //등록
    public int insert(SupportVO supportVO);

    //조회
    public SupportVO read(Long supportNumber);

    public SupportVO get(Long supportNumber);

    public List<SupportVO> getSupportListWithNovelNumber(Long novelNumber);
}
