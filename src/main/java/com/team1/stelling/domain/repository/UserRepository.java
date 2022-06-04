package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserVO, Long>{

    // @Query 테스트
    @Query( value = "SELECT USER_NICKNAME  FROM TBL_USER ", nativeQuery = true)
    List<String>  findByNumber();
    @Query( value = "SELECT *  FROM TBL_USER ", nativeQuery = true)
    List<UserVO>  findByNumberList();
    @Query( value = "SELECT  N.NOVEL_TITLE FROM TBL_USER  U JOIN TBL_NOVEL N ON U.USER_NUMBER = N.USER_NUMBER ", nativeQuery = true)
    List<String>  findByNumberJoinList();
    @Query( value = "SELECT  USER_ID FROM TBL_USER", nativeQuery = true)
    List<String>  findByUserId();

}
