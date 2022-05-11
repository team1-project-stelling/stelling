package com.team1.stelling.mapper;

import com.team1.stelling.domain.vo.Criteria;
import com.team1.stelling.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    //댓글 등록
    public int insert(ReplyVO replyVO);

    //댓글 1개 조회
    public ReplyVO read(Long reply_number);

    //댓글 1개 삭제
    public int delete(Long reply_number);

    //댓글 1개 수정
    public int update(ReplyVO reply_number);

    //댓글 목록
    public List<ReplyVO> getList(Long user_number, Criteria criteria);
}
