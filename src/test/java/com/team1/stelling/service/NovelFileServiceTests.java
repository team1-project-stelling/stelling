package com.team1.stelling.service;

import com.team1.stelling.domain.repository.NovelRepository;
import com.team1.stelling.domain.vo.IllustVO;
import com.team1.stelling.domain.vo.NovelFileVO;
import com.team1.stelling.domain.vo.NovelVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Slf4j
public class NovelFileServiceTests {


    @Autowired
    UserService userService;
    @Autowired
    NovelFileService novelFileService;
    @Autowired
    NovelService novelService;
    @Autowired
    SubNovelService subNovelService;

/*    @Test
    public void registerTest(){

     NovelVO novelVO=  novelService.get(1L);
     NovelFileVO novelFileVO = NovelFileVO.builder()
                .userVO(userService.get(1L))
                .novelVO(novelVO)
                .subNovelVO(subNovelService.get(1L))
                .novelFileFileName("노벨원본파일테스트(1).txt")
                .novelFileFilePath("c:/upload")
                .novelFileOriginalFileName("노벨원본파일테스트.txt")
                .build();

        log.info("##########"+novelFileVO.toString());
        novelFileService.register(novelFileVO);
    }*/

/*    @Test
    public void getTest(){
        NovelFileVO novelFileVO = novelFileService.get(1L);
        log.info("##########"+novelFileVO.toString());
    }*/

/*    @Test
    public void getListTest(){
        List<NovelFileVO> datas = novelFileService.getList();
        datas.forEach(e -> log.info("##########"+e.toString()));
    }*/


/*   @Test
    public void modifyTest() {
       NovelFileVO novelFileVO = novelFileService.get(1L);
       novelFileVO.updateNovelFileFileName("변경된파일이름.txt");
       novelFileService.modify(novelFileVO);
   }*/


}
