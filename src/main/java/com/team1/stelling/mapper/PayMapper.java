package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.PayVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayMapper {
    //등록
    public int insert(PayVO payVO);

    //조회
    public PayVO read(Long payNumber);

    //거래 취소시 삭제?
    public int delete(Long payNumber);
}
