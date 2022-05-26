package com.team1.stelling.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team1.stelling.domain.vo.KakaoProfile;
import com.team1.stelling.domain.vo.UserVO;
import com.team1.stelling.service.OauthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Slf4j
public class OauthController {

    private final OauthService oauthService;

    @RequestMapping(value="/oauth")
    public ModelAndView login(@RequestParam("code") String code, HttpSession session, UserVO userVO) {
        ModelAndView mav = new ModelAndView();
        String accessToken = oauthService.getKakaoAccessToken(code);
        HashMap<String, Object> userInfo = oauthService.getUserInfo(accessToken);
        System.out.println("login info : " + userInfo.toString());

        KakaoProfile kakaoProfile = new KakaoProfile();
//        System.out.println(kakaoProfile.getId());
//        System.out.println(kakaoProfile.getKakaoAccount());

        if(userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("accessToken", accessToken);
        }
        mav.addObject("userId", userInfo.get("email"));
        mav.setViewName("/main/index");
        return mav;
    }
}
