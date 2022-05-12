package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.InquiryVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InquiryMapper {
    //등록
    public int insert(InquiryVO inquiryVO);

    //조회
    public InquiryVO read(Long inquiryNumber);

    //삭제?
    public int delete(Long inquiryNumber);
}
