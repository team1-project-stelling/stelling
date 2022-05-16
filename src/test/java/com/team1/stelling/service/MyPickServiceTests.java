package com.team1.stelling.service;

import com.team1.stelling.domain.vo.MyPickVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class MyPickServiceTests {
    @Autowired
    MyPickService myPickService;
    @Autowired
    UserService userService;
    @Autowired
    NovelService novelService;

/*    @Test
   public void getTest(){
        MyPickVO myPickVO =  myPickService.get(1L);
        log.info(myPickVO.toString());
    }*/
    @Test
    public void register(){
        MyPickVO myPickVO = MyPickVO.builder()
                .novelVO(novelService.get(1L))
                .userVO(userService.get(1L))
                .build();
        myPickService.register(myPickVO);
    }
}
