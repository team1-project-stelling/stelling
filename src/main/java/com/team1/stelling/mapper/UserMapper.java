package com.team1.stelling.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
    public Integer login(Map<String, String> loginMap);
    public int idCheck(String userId);
    public int emailCheck(String userEmail);
    public String getSearchId(String userNick, String phoneNum);
    public String getSearchPw(String userId, String userEmail);
    public String findPw(String userId, String userEmail);
}
