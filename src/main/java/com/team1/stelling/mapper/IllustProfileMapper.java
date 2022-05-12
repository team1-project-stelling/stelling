package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.IllustProfileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IllustProfileMapper {
    //등록
    public int insert(IllustProfileVO illustProfileVO);

    //조회
    public IllustProfileVO read(Long illustProfileNumber);

    //삭제?
    public int delete(Long illustProfileNumber);
}
