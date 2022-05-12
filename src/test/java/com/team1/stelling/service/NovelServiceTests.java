package com.team1.stelling.service;

import com.team1.stelling.domain.vo.NovelVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Slf4j
public class NovelServiceTests {



    @Autowired
    NovelService novelService;
    @Autowired
    UserService userService;
/*    @Test
    public void getTest(){
        NovelVO novelVO = novelService.get(1L);
        log.info("########"+novelVO.toString());
    }*/
/*    @Test
    public void getListTest(){
        List<NovelVO> datas = novelService.getList();
        datas.forEach(e -> log.info("#####"+e.toString()));
    }*/
/*    @Test
    public void register(){
        NovelVO novelVO = NovelVO.builder()
                .userVO(userService.get(1L))
                .novelCategory("#이세계")
                .novelHashtag("#이세계#전생#환생#모에화")
                .novelIntro("잘봐주세요")
                .novelTitle("테스트2번소설")
                .novelSerialsStatus(1)
                .novelStatus(0)
                .novelCategory("로맨스")
                .build();
        novelService.register(novelVO);
    }*/
/*    @Test
    public void modifyTest(){
        NovelVO novelVO = novelService.get(2L);
        novelVO.updateNovelFriDay(1);
        novelVO.updateNovelThursDay(1);
        novelVO.updateNovelCategory("#로맨스");
        novelService.modify(novelVO);
    }*/
    
}
