package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.MyIllustVO;
import com.team1.stelling.domain.vo.PayVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayMapper {
    //등록
    public int insert(PayVO payVO);

    //조회
    public PayVO read(Long payNumber);

    public int update(PayVO payVO);

    //거래 취소시 삭제?
    public int delete(Long payNumber);

//    public PayVO get(Long payNumber);
    public List<PayVO> getList(Long userNumber);
}
