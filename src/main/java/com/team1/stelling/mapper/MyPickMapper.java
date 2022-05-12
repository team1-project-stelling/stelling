package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.MyPickVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPickMapper {
    //등록
    public int insert(MyPickVO myPickVO);

    //조회
    public MyPickVO read(Long myPickNumber);

    //삭제?
    public int delete(Long myPickNumber);
}
