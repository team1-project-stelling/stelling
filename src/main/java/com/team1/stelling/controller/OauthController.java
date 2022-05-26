package com.team1.stelling.controller;

import com.team1.stelling.service.OauthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class OauthController {

    private final OauthService oauthService;

    @RequestMapping(value="/oauth")
    public ModelAndView login(@RequestParam("code") String code, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        String accessToken = oauthService.getKakaoAccessToken(code);
        HashMap<String, Object> userInfo = oauthService.getUserInfo(accessToken);
        System.out.println("login info : " + userInfo.toString());

        if(userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("accessToken", accessToken);
        }
        mav.addObject("userId", userInfo.get("email"));
        mav.setViewName("/main/index");
        return mav;
    }
}
