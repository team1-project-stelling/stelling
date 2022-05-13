package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.BuyChapterVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyChapterMapper {
    //등록
    public int insert(BuyChapterVO buyChapterVO);

    //조회
    public BuyChapterVO read(Long buyChapterNumber);

    public int update(BuyChapterVO buyChapterVO);

    //삭제?
    public int delete(Long buyChapterNumber);

    //특정 결제 내역 가져오기
    public BuyChapterVO get(Long buyChapterNumber);
}
