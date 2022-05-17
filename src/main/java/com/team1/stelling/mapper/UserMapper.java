package com.team1.stelling.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
    //로그인
    public Integer login(Map<String, String> loginMap);
}
