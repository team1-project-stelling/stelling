package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.MyIllustVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyIllustMapper {
    //등록
    public int insert(MyIllustVO myIllustVO);

    //조회
    public MyIllustVO read(Long myIllustNumber);

    public int update(MyIllustVO myIllustVO);

    //삭제?
    public int delete(Long myIllustNumber);

    public MyIllustVO get(Long myIllustNumber);
}
