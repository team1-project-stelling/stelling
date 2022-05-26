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
    public int idCheck(String userId) { return userMapper.idCheck(userId); }
    public int emailCheck(String userEmail) { return userMapper.emailCheck(userEmail); }
    public String getSearchId(String userNick, String phoneNum) { return userMapper.getSearchId(userNick, phoneNum); }
    public String getSearchPw(String userId, String userEmail) { return userMapper.getSearchPw(userId, userEmail); }
    public String findPw(String userId, String userEmail) {return userMapper.findPw(userId, userEmail) ; }
}
