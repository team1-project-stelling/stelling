package com.team1.stelling.service;//package com.team1.stelling.service;

import com.team1.stelling.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class UserServiceTests {
    @Autowired
    UserService userService;
    @Test
    public void registerTest(){
        UserVO userVO = UserVO.builder()
                .userEmail("zlatan99@naver.com")
                .userGender(1)
                .userId("zlatan99")
                .userNickName("즐라탄입니다")
                .userPhoneNum("01012121234")
                .userPw("0000")
                .userStatus(1)
                .build();
        userService.register(userVO);
    }
/*    @Test
    public void getTest(){
        UserVO userVO = userService.get(2L);
        log.info("#########"+userVO.toString());
    }*/
//    @Test
//    public void getListTest(){
//        List<UserVO> datas = userService.getList();
//        datas.forEach(e -> log.info("########"+e.toString()));
//    }
//   @Test
//    public void modifyTest(){
//        UserVO userVO = userService.get(2L);
//        userVO.updateUserPw("asdfas");
//        userVO.updateUserEmail("afsdfa@naver.com");
//        userService.modify(userVO);
//    }
}


