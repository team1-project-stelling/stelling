package com.team1.stelling.controller;

import com.team1.stelling.domain.vo.UserDTO;
import com.team1.stelling.domain.vo.UserVO;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String findId() {
        return "user/userFindId";
    }

    @GetMapping("/findPw")
    public String findPw() {
        return "user/userFindPw";
    }

    @GetMapping("/join")
    public String join() {
        return "user/userJoin";
    }

    @GetMapping("/login")
    public String login() {
        return "user/userLogin";
    }

    @GetMapping("/agree")
    public String agree() {
        return "etc/agree";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "etc/privacy";
    }


    private final UserService userService;

    @PostMapping("/joinUs.do")
    public String joinUs(UserVO vo, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.setAttribute("userNumber", vo.getUserNumber());
        userService.joinUser(vo);
        return "user/userLogin";
    }

    @PostMapping("/login")
    public String login(UserDTO dto, HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        Integer userNumber = 0;

        HashMap<String, String> loginMap = new HashMap<>();
        loginMap.put("userId", dto.getUserId());
        loginMap.put("userPw", dto.getUserPw());
        
        //회원 정보가 없으면 null이 담긴다
        userNumber = userService.login(loginMap); 

        if (userNumber == null) {
            log.info("========로그인 실패========");
            model.addAttribute("msg", "로그인실패");
            return "user/userLogin";
        } else {
            log.info("========로그인 성공========");
            session.setAttribute("userNumber", userNumber);
            return "redirect:/main/index";
        }
    }

    /////////////////////////////////////////
    // 아이디 중복확인
    @ResponseBody // 값 변환을 위해 꼭 필요함
    @PostMapping("/idCheck") // 아이디 중복확인을 위한 값으로 따로 매핑
    public int overlappedID(String userId){
        int count = 0;
        count = userService.idCheck(userId);
        log.info("#######################" + count);
        return count;
    }

    /////////////////////////////////////////
    // 이메일 중복확인
    @ResponseBody // 값 변환을 위해 꼭 필요함
    @PostMapping("/emailCheck") // 아이디 중복확인을 위한 값으로 따로 매핑
    public int overlappedEmail(String userEmail){
        int count = 0;
        count = userService.idCheck(userEmail);
        log.info("#######################" + count);
        return count;
    }
}