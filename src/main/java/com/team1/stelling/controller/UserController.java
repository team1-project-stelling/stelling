package com.team1.stelling.controller;

import com.team1.stelling.domain.repository.UserRepository;
import com.team1.stelling.domain.vo.UserVO;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/findId")
    public String findId(){
        return "user/userFindId";
    }

    @GetMapping("/findPw")
    public String findPw(){
        return "user/userFindPw";
    }

    @GetMapping("/join")
    public String join(){
        return "user/userJoin";
    }

    @GetMapping("/login")
    public String login(){ return "user/userLogin"; }

    @GetMapping("/agree")
    public String agree(){
        return "etc/agree";
    }

    @GetMapping("/privacy")
    public String privacy(){
        return "etc/privacy";
    }


    private final UserService userService;

    @PostMapping("/joinUs.do")
    public String joinUs(UserVO vo){

        userService.joinUser(vo);
        return "main/index";
    }


}
