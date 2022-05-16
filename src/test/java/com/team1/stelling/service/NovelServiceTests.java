package com.team1.stelling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
@RequiredArgsConstructor
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
                .userVO(userService.get(2L))
                .novelCategory("#메카")
                .novelHashtag("#메카#전투#환생#건담")
                .novelIntro("건담좋아해요?")
                .novelTitle("테스트3번소설")
                .novelSerialsStatus(1)
                .novelStatus(0)
                .novelFileName("파일 이름")
                .novelUUID("UUID")
                .novelUploadPath("C:/upload")
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

/*    @Test
    public void getEndNovelListTest(){
        novelService.getEndNovelList().forEach(e->log.info(e.toString()));
    }*/
    
}
