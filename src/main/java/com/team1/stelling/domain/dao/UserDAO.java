package com.team1.stelling.domain.dao;

import com.team1.stelling.domain.vo.UserVO;
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

    public Long login(Map<String, String> loginMap) {return userMapper.login(loginMap);}
    public int idCheck(String userId) { return userMapper.idCheck(userId); }
    public String getSearchId(String userNick, String phoneNum) { return userMapper.getSearchId(userNick, phoneNum); }
    public String findPw(String userId, String userEmail) {return userMapper.findPw(userId, userEmail) ; }
    public UserVO findUserId(String userId) {return userMapper.findUserId(userId) ; }
    public UserVO findByUserId(String userId){return userMapper.findByUserId(userId);}
    public UserVO findByUserNumber(Long userNumber){return userMapper.findByUserNumber(userNumber);}
    public UserVO findUserEmail(String userEmail) {return userMapper.findUserEmail(userEmail) ; }
}
