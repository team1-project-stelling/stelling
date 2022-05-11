package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserVO, Long>{

}
