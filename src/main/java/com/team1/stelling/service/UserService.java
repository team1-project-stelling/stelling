package com.team1.stelling.service;

import com.team1.stelling.domain.dao.UserDAO;
import com.team1.stelling.domain.repository.UserRepository;
import com.team1.stelling.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserDAO userDAO;

    public UserVO get(Long userNumber){return userRepository.findById(userNumber).get();}
    public List<UserVO> getList(){return userRepository.findAll();}
    public void register(UserVO vo){ userRepository.save(vo);}
    public void modify(UserVO vo){ userRepository.save(vo);}


    public String findUserNickName(Long userNum){
     String userNickName = userRepository.findById(userNum).orElse(null).getUserNickName();
        if(Objects.isNull(userNickName)){
            log.info("없는 사용자");
        }
        return userNickName;
    }

    public void joinUser(UserVO vo) { userRepository.save(vo); }
    public Integer login(Map<String, String> loginMap) {return userDAO.login(loginMap);}
    public int idCheck(String userId) { return userDAO.idCheck(userId); }
    public int emailCheck(String userEmail) { return userDAO.emailCheck(userEmail); }
    public String getSearchId(String userNick, String phoneNum){ return userDAO.getSearchId(userNick, phoneNum) ; }
    public String getSearchPw(String userId, String userEmail){ return userDAO.getSearchPw(userId, userEmail) ; }
    public String findPw(String userId, String userEmail) { return userDAO.findPw(userId,userEmail) ; }
}
