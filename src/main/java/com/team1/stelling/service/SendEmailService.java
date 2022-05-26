package com.team1.stelling.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SendEmailService {
    private JavaMailSender javaMailSender;

    public void sendEmail(String result, String userEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hun39500528@gmail.com");
        message.setTo(userEmail);
        message.setSubject("Stelling 계정");
        message.setText("고객님의 비밀번호는 [" + result + "] 입니다.");
        javaMailSender.send(message);
    }
}
