package com.team1.stelling.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
    //로그인
    public int login(Map<String, String> loginMap);
}
