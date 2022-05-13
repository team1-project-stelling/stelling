package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.SupportVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupportMapper {
    //등록
    public int insert(SupportVO supportVO);

    //조회
    public SupportVO read(Long supportNumber);

    public SupportVO get(Long supportNumber);
}
