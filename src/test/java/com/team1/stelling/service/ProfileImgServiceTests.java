package com.team1.stelling.service;

import com.team1.stelling.domain.vo.ProfileImgFileVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Slf4j
public class ProfileImgServiceTests {



    @Autowired
    NovelService novelService;
    @Autowired
    UserService userService;
    @Autowired
    ProfileImgService profileImgService;


/*    @Test
    public void registerTest(){
        ProfileImgFileVO profileImgFileVO = ProfileImgFileVO.builder()
                .userVO(userService.get(1L))
                .profileImgFileFileName("프로필사진.png")
                .profileImgFileFilePath("c:/upload")
                .profileImgFileOriginFileName("프로필사진.png")
                .build();
        profileImgService.register(profileImgFileVO);
    }*/
/*    @Test
    public void getTest(){
        ProfileImgFileVO profileImgFileVO =  profileImgService.get(1L);
        log.info("#######"+profileImgFileVO.toString());
        log.info("#######"+profileImgFileVO.getUserVO().toString());
    }*/
/*    @Test
    public void getListTest(){
        List<ProfileImgFileVO> datas = profileImgService.getList();
        datas.forEach(e -> log.info("####"+e.toString()));
    }*/
/*    @Test
    public void modify(){
        ProfileImgFileVO profileImgFileVO = profileImgService.get(1L);
        profileImgFileVO.updateProfileImgFileFileName("프로필사진 수정.png");
        profileImgService.modify(profileImgFileVO);
    }*/
    
}
