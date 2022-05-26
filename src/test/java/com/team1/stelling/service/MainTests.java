package com.team1.stelling.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MainTests {
    @Autowired
    MainService mainService;

    @Test
    public void testGetNewIllust(){
        mainService.getNewIllustList().forEach(e -> log.info(e.toString()));
    }
}
