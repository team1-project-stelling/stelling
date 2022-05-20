package com.team1.stelling.service;

import com.team1.stelling.domain.repository.UserRepository;
import com.team1.stelling.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final  UserRepository userRepository;

    public UserVO get(Long userBno){
        return userRepository.findById(userBno).get();
    }
    public List<UserVO> getList(){return userRepository.findAll(); }
    public void register(UserVO vo){ userRepository.save(vo);}
    public void modify(UserVO vo){ userRepository.save(vo);}
    public String findUserNickName(Long userNum){
     String userNickName = userRepository.findById(userNum).orElse(null).getUserNickName();
        if(Objects.isNull(userNickName)){
            log.info("없는 사용자");
        }
        return userNickName;
    }
}
