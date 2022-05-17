package com.team1.stelling.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class RecentViewServiceTests {



    @Autowired
    NovelService novelService;
    @Autowired
    UserService userService;
    @Autowired
    RecentViewService recentViewService;

/*    @Test
    public void register(){
        RecentViewVO recentViewVO = RecentViewVO.builder()
                .novelVO(novelService.get(1L))
                .userVO(userService.get(1L))
                .build();
        recentViewService.register(recentViewVO);
    }*/
/*    @Test
    public void getTest(){
        RecentViewVO recentViewVO = recentViewService.get(1L);
        log.info("######"+recentViewVO.toString());
    }*/
/*    @Test
    public void getListTest(){
         List<RecentViewVO> datas = recentViewService.getList();
         datas.forEach(e -> log.info("####"+e.toString()));
    }*/

}
