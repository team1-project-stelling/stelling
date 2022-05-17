package com.team1.stelling.controller;

import com.team1.stelling.domain.vo.UserDTO;
import com.team1.stelling.domain.vo.UserVO;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    public String joinUs(UserVO vo, HttpServletRequest request){
//        HttpSession session = request.getSession();
//        session.setAttribute("userNumber", vo.getUserNumber());
        userService.joinUser(vo);
        return "user/userLogin";
    }

    @PostMapping("/login")
    public String login(UserDTO dto, HttpServletRequest req){
        HttpSession session = req.getSession();
        int userNumber = 0;

        HashMap<String, String> loginMap = new HashMap<>();
        loginMap.put("userId", dto.getUserId());
        loginMap.put("userPw", dto.getUserPw());

        if(userNumber == 0) {
            userNumber = userService.login(loginMap);
            session.setAttribute("userNumber", userNumber);
            return "main/index";
        } else {
            return "user/userLogin";
        }
    }
}
