package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.InquiryVO;
import com.team1.stelling.domain.vo.MyIllustVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InquiryMapper {
    //등록
    public int insert(InquiryVO inquiryVO);

    //상세 보기
    public InquiryVO read(Long inquiryNumber);

    public int update(InquiryVO inquiryVO);

    //삭제?
    public int delete(Long inquiryNumber);

    public InquiryVO get(Long inquiryNumber);
}
