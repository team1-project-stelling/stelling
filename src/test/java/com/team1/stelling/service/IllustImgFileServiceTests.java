package com.team1.stelling.service;

import com.team1.stelling.domain.vo.IllustImgFileVO;
import com.team1.stelling.domain.vo.IllustVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class IllustImgFileServiceTests {
    @Autowired
    IllustImgFileService illustImgFileService;
    @Autowired
    UserService userService;
    @Autowired
    IllustService illustService;

/*    @Test
    public void getListTest(){
            List<IllustImgFileVO>  datas =illustImgFileService.getList();
            datas.forEach(e -> log.info("@@@@@@@"+e.toString()));
    }*/

/*    @Test
    public void registerTest(){
        IllustVO illustVO = illustService.get(1L);
        log.info("@@@@@@@"+illustVO.toString());
        UserVO userVO = userService.get(1L);
        log.info("@@@@@@@"+userVO.toString());
        IllustImgFileVO illustImgFileVO = IllustImgFileVO.builder()
                .illustImgFileFileName("JPA단위테스트(1).png")
                .illustImgFileFilePath("c:/upload")
                .illustImgFileOriginFileName("JPA단위테스트.png")
                .userVO(userVO)
                .illustVO(illustVO)
                .build();
        log.info("###########"+illustImgFileVO.toString());
        illustImgFileService.register(illustImgFileVO);
    }*/

/*    @Test
    public void getIllustImgFileTest(){
         IllustImgFileVO illustImgFileVO= illustImgFileService.get(1L);
         log.info(illustImgFileVO.toString());
    }*/
        @Test
    public void modifyTests(){
            IllustImgFileVO illustImgFileVO= illustImgFileService.get(1L);
            illustImgFileVO.updateIllustImgFileFileName("테스트파일이름UPDATE.png");
            illustImgFileService.modify(illustImgFileVO);
    }

}
