package com.team1.stelling.service;

import com.team1.stelling.domain.dao.ReplyDAO;
import com.team1.stelling.domain.repository.ReplyRepository;
import com.team1.stelling.domain.vo.ReplyVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReplyService{
    private final ReplyRepository replyRepository;

    public ReplyVO get(Long replyNo){return  replyRepository.findById(replyNo).get();}
    public List<ReplyVO> getList(Long subNovelNumber){return replyRepository.findAllBySubNovelVO_SubNovelNumberOrderByReplyNumber(subNovelNumber); }
    public List<UserVO> getUserList(Long subNovelNumber){return replyRepository.findAllBySubNovelVO_SubNovelNumberOrderByReplyNumber(subNovelNumber)
                                                        .stream().map(v->v.getUserVO()).collect(Collectors.toList());}
    public void register(ReplyVO replyVo){replyRepository.save(replyVo);}
    public void modify(ReplyVO replyVO){
        replyVO.updateReplyUpdateDate();
        replyRepository.save(replyVO);
    }
    public List<ReplyVO> getReplyListLatest(Long novelNumber){return replyRepository.findAllByNovelVO_NovelNumberOrderByReplyNumber(novelNumber); }
    public List<ReplyVO> getReplyListRecommend(Long novelNumber){return replyRepository.findAllByNovelVO_NovelNumberOrderByReplyUpDesc(novelNumber); }

}
