package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.BuyChapterVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyChapterMapper {
    //등록
    public int insert(BuyChapterVO buyChapterVO);

    //조회
    public BuyChapterVO read(Long buyChapterNumber);

    //삭제?
    public int delete(Long buyChapterNumber);
}
