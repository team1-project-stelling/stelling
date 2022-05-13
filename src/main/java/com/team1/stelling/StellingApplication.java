package com.team1.stelling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // 스케줄 권한 허용
@SpringBootApplication
public class StellingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StellingApplication.class, args);
    }

}
