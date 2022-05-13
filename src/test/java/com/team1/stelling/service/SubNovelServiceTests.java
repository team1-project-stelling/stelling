package com.team1.stelling.service;

import com.team1.stelling.domain.vo.SubNovelVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Slf4j
public class SubNovelServiceTests {



    @Autowired
    NovelService novelService;
    @Autowired
    UserService userService;
    @Autowired
    SubNovelService subNovelService;

    @Test
    public void registerTest(){
        SubNovelVO subNovelVO = SubNovelVO.builder()
                .novelVO(novelService.get(1L))
                .userVO(userService.get(1L))
                .subNovelStatus(1)
                .subNovelTitle("전쟁의서막 ")
                .subNovelWriterComment("첫 회 연재 시작 하였습니다")
                .build();
        subNovelService.register(subNovelVO);
    }
/*    @Test
    public void getTest(){
        SubNovelVO subNovelVO = subNovelService.get(2L);
        log.info("######"+subNovelVO.toString());
    }*/
/*    @Test
    public void getListTest(){
        List<SubNovelVO> datas = subNovelService.getList();
        datas.forEach(e -> log.info("#####"+e.toString()));
    }*/
/*    @Test
    public void modifyTest(){
        SubNovelVO subNovelVO = subNovelService.get(2L);
        subNovelVO.updateSubNovelViewCount();
        subNovelVO.updateSubNovelLickCount();
        subNovelVO.updateSubNovelWriterComment("1회자 수정");
        subNovelService.modify(subNovelVO);
    }*/
    
}
