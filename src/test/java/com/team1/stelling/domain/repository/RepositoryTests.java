package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.IllustImgFileVO;
import com.team1.stelling.domain.vo.IllustVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class RepositoryTests {

    @Autowired
    private IllustImgFileRepository illustImgFileRepository;
    @Autowired
    private IllustRepository illustRepository;
    @Autowired
    private UserRepository userRepository;

/*    @Test
    public void illImgFileTests(){
       List<IllustImgFileVO> datas = illustImgFileRepository.findAll();
       datas.forEach(e ->log.info(e.toString()));
    }*/

/*    @Test
    public void illustGetListTest(){
        List<IllustVO> datas =  illustRepository.findAll();
        datas.forEach(e ->log.info("@@@@@@@@@@@"+e.toString()));
    }*/
/*    @Test
    public void getTest(){
        IllustVO illustVO =  illustRepository.findById(1L).get();
        log.info(illustVO.toString());
    }*/
    @Test
    public void queryATet(){
/*       List<String> datas= userRepository.findByNumber();
       datas.forEach(e -> log.info("@#@#"+e));*/
//        List<UserVO> datas =   userRepository.findByNumberList();
//        datas.forEach(e -> log.info("#######"+e.toString()));
         List<String> datas = userRepository.findByNumberJoinList();
         datas.forEach(e ->log.info("#####"+e));


    }
}
