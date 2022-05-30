package com.team1.stelling.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.team1.stelling.domain.vo.KakaoProfile;
import com.team1.stelling.domain.vo.OauthToken;
import com.team1.stelling.domain.vo.UserVO;
import com.team1.stelling.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Slf4j
public class OauthController {

    private final UserService userService;

    @GetMapping("/oauth")
    public @ResponseBody String kakaoCallback(HttpServletRequest request, String code) throws IOException {

        String grant_type = "authorization_code";
        String client = "427b7ad60b17680502910b084533fbaa";
        String redirect_uri = "http://localhost:8989/user/oauth";

        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", grant_type);
        params.add("client_id", client);
        params.add("redirect_uri", redirect_uri);
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params,headers);

        ResponseEntity response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        System.out.println("카카오 엑세스 토큰 :" + response.getBody());

        //Json 데이터 Java 객체로 가져오기 (OauthToken.class) (60~82)
        //GSON, Json Simple, ObjectMapper

//        //GSON
//        JsonParser parser = new JsonParser();
//        JsonElement element = parser.parse(String.valueOf(response));
//
//        String access_Token = "";
//        access_Token = element.getAsJsonObject().get("access_token").getAsString();
//
//        oauthToken.setAccess_token(access_Token);
//
//        System.out.println("카카오 엑세스 토큰 :" + oauthToken.getAccess_token());

        //ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        OauthToken oauthToken = null;
//        try {
//            oauthToken = objectMapper.readValue(response.getBody(), OauthToken.class);
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }


        RestTemplate rt2 = new RestTemplate();

        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization", "Bearer " + oauthToken.getAccess_token());
        headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 = new HttpEntity<>(headers2);

        ResponseEntity response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest2,
                String.class
        );

        KakaoProfile kakaoProfile = null;
        ObjectMapper objectMapper2 = new ObjectMapper();
//        try {
//            kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        UUID garbagePassword = UUID.randomUUID();

        UserVO kakaoUser = UserVO.builder()
                .userNickName(kakaoProfile.getKakao_account().getEmail() + "_" + kakaoProfile.getId())
                .userPw(garbagePassword.toString())
                .userEmail(kakaoProfile.getKakao_account().getEmail())
                .userGender(0)
                .userPhoneNum("0")
                .userStatus(0)
                .userCoinBalance(0)
                .userAccessToken((String) response.getBody())
                .userFilePath("stelling")
                .userUuid("basic")
                .userFileName("profile.png")
                .build();

        UserVO originUser = userService.findUserEmail(kakaoUser.getUserEmail());

        if (originUser == null) {
            userService.joinUser(kakaoUser);
            HttpSession session = request.getSession();
            session.setAttribute("userNumber", kakaoUser.getUserNumber());
            session.setAttribute("user",userService.get(kakaoUser.getUserNumber()));
            log.info("###########" +session.getAttribute("userNumber"));
            return "redirect:/main/index";
        }

        HttpSession session = request.getSession();
        session.setAttribute("userNumber", kakaoUser.getUserNumber());
        session.setAttribute("user",userService.get(kakaoUser.getUserNumber()));
        log.info("###########" +session.getAttribute("userNumber"));
        return "redirect:/main/index";

    }
}










