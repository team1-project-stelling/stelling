package com.team1.stelling.domain.dao;

import com.team1.stelling.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserDAO {
    private final UserMapper userMapper;

    public Integer login(Map<String, String> loginMap) {return userMapper.login(loginMap);}

    //아이디 중복검사
    public int idCheck(String userId) { return userMapper.idCheck(userId); }

    //이메일 중복검사
    public int emailCheck(String userEmail) { return userMapper.emailCheck(userEmail); }
}
