package com.team1.stelling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class CertifiedPhoneService {
    public void certifiedPhoneNumber(String phoneNumber, String cerNum) {
        String api_key = "NCSA215OZXCVQSTH";
        String api_secret = "RSZ54VQGNMG3ZFEVEC2CZTSCILTOR0O8";
        Message coolsms = new Message(api_key, api_secret);

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phoneNumber);
        params.put("from", "01083405028");
        params.put("type", "SMS");
        params.put("text", "[test] 인증번호는" + "["+cerNum+"]" + "입니다.");
        params.put("app_version", "test app 1.2");

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
    }

    public void sendPw(String phoneNumber, String cerNum){

        String api_key = "NCSA215OZXCVQSTH";
        String api_secret = "RSZ54VQGNMG3ZFEVEC2CZTSCILTOR0O8";
        Message coolsms = new Message(api_key, api_secret);

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phoneNumber);
        params.put("from", "01083405028");
        params.put("type", "SMS");
        params.put("text", "[test] 고객님의 비밀번호는" + "["+cerNum+"]" + "입니다.");
        params.put("app_version", "test app 1.2");

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
    }
}
