package com.team1.stelling.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/user/*")
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
    public String login(){
        return "user/userLogin";
    }

    @GetMapping("/agree")
    public String agree(){
        return "etc/agree";
    }

    @GetMapping("/privacy")
    public String privacy(){
        return "etc/privacy";
    }
}
