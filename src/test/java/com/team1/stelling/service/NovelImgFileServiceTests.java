package com.team1.stelling.service;

import com.team1.stelling.domain.vo.NovelImgFileVO;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class NovelImgFileServiceTests {


    @Autowired
    NovelImgFileService novelImgFileService;
    @Autowired
    UserService userService;
    @Autowired
    NovelService novelService;
/*    @Test
    public void getTest(){
        NovelImgFileVO novelImgFileVO = novelImgFileService.get(1L);
        log.info("##########"+novelImgFileVO.toString());
    }*/
/*    @Test
    public void registerTest(){
        NovelImgFileVO novelImgFileVO = NovelImgFileVO.builder()
                .novelVO(novelService.get(1L))
                .userVO(userService.get(1L))
                .novelImgFileFileName("이미지파일이름(1).png")
                .novelImgFileFilePath("c:/upload")
                .novelImgFileOriginFileName("이미지파일이름.png")
                .build();
                novelImgFileService.register(novelImgFileVO);
    }*/
/*    @Test
    public void modifyTest(){
        NovelImgFileVO novelImgFileVO = novelImgFileService.get(1L);
        novelImgFileVO.updateNovelImgFileFileName("수정된 파일이름");
        novelImgFileVO.updateNovelImgFileOriginFileName("수정된원본파일이름");
        novelImgFileService.modify(novelImgFileVO);
    }*/

}
