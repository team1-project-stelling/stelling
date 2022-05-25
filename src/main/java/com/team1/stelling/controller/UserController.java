package com.team1.stelling.controller;

import com.team1.stelling.domain.vo.UserDTO;
import com.team1.stelling.domain.vo.UserVO;
import com.team1.stelling.service.CertifiedPhoneService;
import com.team1.stelling.service.SendEmailService;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Random;

@Controller
@Slf4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CertifiedPhoneService certifiedPhoneService;
    private final SendEmailService sendEmailService;

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
        
        userNumber = userService.login(loginMap);

        if (userNumber == null) {
            log.info("========로그인 실패========");
            model.addAttribute("msg", "로그인실패");
            return "user/userLogin";
        } else {
            log.info("========로그인 성공========");
            session.setAttribute("userNumber", userNumber);
            session.setAttribute("user", userService.get(Long.valueOf(userNumber)));

            return "redirect:/main/index";
        }
    }

    @ResponseBody
    @PostMapping("/idCheck")
    public int overlappedID(String userId){
        int count = 0;
        count = userService.idCheck(userId);
        log.info("#######################" + count);
        return count;
    }

    @ResponseBody
    @PostMapping("/emailCheck")
    public int overlappedEmail(String userEmail){
        int count = 0;
        count = userService.idCheck(userEmail);
        log.info("#######################" + count);
        return count;
    }
    @GetMapping("/sendSMS")
    public @ResponseBody String sendSMS (String phoneNumber) {
        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr += ran;
        }
        certifiedPhoneService.certifiedPhoneNumber(phoneNumber,numStr);
        return numStr;
    }

    @PostMapping("/userFindId")
    @ResponseBody
    public String userFindId(String userNick, String phoneNum){
        String result = userService.getSearchId(userNick, phoneNum);
        return result;
    }

    @PostMapping("/userFindPw")
    @ResponseBody
    public String sendEmail(String userId, String userEmail){
        String result = userService.findPw(userId, userEmail);
        if (result != "") {
            sendEmailService.sendEmail(result, userEmail);
            return result;
        }
        return result;
    }
}