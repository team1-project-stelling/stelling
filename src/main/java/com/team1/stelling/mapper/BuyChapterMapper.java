package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.BuyChapterVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    //소설넘버로 서브노벨넘버리스트 가져오기
    public List<Long> getSubNovelNumByNovelNum(Long novelNumber, Long userNumber);
}
