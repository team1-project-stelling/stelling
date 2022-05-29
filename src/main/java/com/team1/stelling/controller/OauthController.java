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

        //인가코드 작성 양식 (30~44)
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

        //카카오에 인가코드 전달
        ResponseEntity response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        //전달한 인가코드로 엑세스 토큰 받아옴
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


        //사용자 정보 요청
        RestTemplate rt2 = new RestTemplate();

        //HttpHeader 오브젝트 생성
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

        //사용자 정보 KakaoProfile에 담은 후 출력
        KakaoProfile kakaoProfile = null;
        ObjectMapper objectMapper2 = new ObjectMapper();
//        try {
//            kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        //UserVO 오브젝트 : username, password, email
        System.out.println("카카오 아이디(번호Sequence) : " + kakaoProfile.getId());
        System.out.println("카카오 이메일 : " + kakaoProfile.getKakao_account().getEmail());

        //임의로 설정해준 userName
        //강제 회원가입 시키기
        System.out.println("서버 userName : " + kakaoProfile.getKakao_account().getEmail() + "_" + kakaoProfile.getId());
        System.out.println("서버 Email" + kakaoProfile.getKakao_account().getEmail());
        UUID garbagePassword = UUID.randomUUID();
        System.out.print("서버 Pw" + garbagePassword);

        //UserVO에 강제 세팅
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

        //가입자 , 비가입자 체크 후 처리
        UserVO originUser = userService.findUserEmail(kakaoUser.getUserEmail());

        if (originUser == null) {
            userService.joinUser(kakaoUser);
            HttpSession session = request.getSession();
            session.setAttribute("userNumber", kakaoUser.getUserNumber());
            session.setAttribute("user",userService.get(kakaoUser.getUserNumber()));
            log.info("###########" +session.getAttribute("userNumber"));
            return "redirect:/main/index";
        }

        //로그인 처리
        HttpSession session = request.getSession();
        session.setAttribute("userNumber", kakaoUser.getUserNumber());
        session.setAttribute("user",userService.get(kakaoUser.getUserNumber()));
        log.info("###########" +session.getAttribute("userNumber"));
        return "redirect:/main/index";

    }
}










