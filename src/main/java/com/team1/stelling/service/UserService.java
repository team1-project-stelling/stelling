package com.team1.stelling.service;

import com.team1.stelling.domain.repository.UserRepository;
import com.team1.stelling.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
=======
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
>>>>>>> f142c6365e7512699af313bd2f18acf87618a95a
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserVO get(Long userNumber){
        return userRepository.findById(userNumber).get();
    }
    public List<UserVO> getList(){return userRepository.findAll(); }
    public void register(UserVO vo){ userRepository.save(vo);}
    public void modify(UserVO vo){ userRepository.save(vo);}

//    public boolean checkEmailDuplicate(String email){
//        return userRepository.existsByUserEmail(email);
//    }
//    public boolean checkNickNameDuplicate(String nickName){
//        return userRepository.existsByUserNickName(nickName);
//    }

    public void joinUser(UserVO vo) { userRepository.save(vo); }

}
