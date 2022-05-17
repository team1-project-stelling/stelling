package com.team1.stelling.mapper;

import com.team1.stelling.domain.dto.IllustProfileDTO;
import com.team1.stelling.domain.vo.IllustProfileVO;
import com.team1.stelling.domain.vo.MyIllustVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IllustProfileMapper {
    //등록
    public int insert(IllustProfileVO illustProfileVO);

    //조회
    public IllustProfileVO read(Long illustProfileNumber);

    public int update(IllustProfileVO illustProfileVO);

    //삭제?
    public int delete(Long illustProfileNumber);

    public IllustProfileDTO get(Long userNumber);
}
