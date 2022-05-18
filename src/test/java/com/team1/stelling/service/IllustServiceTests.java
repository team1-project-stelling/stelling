package com.team1.stelling.service;

import com.team1.stelling.domain.vo.IllustVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class IllustServiceTests {

    @Autowired
    IllustService illustService;
    @Autowired
    UserService userService;

/*    @Test
    public void getTest(){
        IllustVO illustVO= illustService.get(1L);
        log.info(illustVO.toString());
    }*/
/*    @Test
    public void getListTest(){
        List<IllustVO> datas = illustService.getList();
        datas.forEach(e -> log.info(e.toString()));
    }*/
/*    @Test
    public void registerTest(){

        IllustVO illustVO = IllustVO.builder()
                .userVO(userService.get(1L))
                .illustContent("단위테스트 내용")
                .illustHashTag("#단위#테스트#이세계#전생")
                .illustShortIntro("단위테스트 하고있습니다 ")
                .illustTitle("단위테스트")
                .build();

        illustService.register(illustVO);
    }*/

    @Test
    public void modifyTest(){
        IllustVO illustVO = illustService.get(2L);
        illustVO.updateIllustContent("내용수정테스트");
        illustVO.updateIllustLike();
        illustVO.updateIllustViewCount();
        illustVO.updateIllustTitle("제목수정테스트");
        illustService.modify(illustVO);
    }

}
