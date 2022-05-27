package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.ChatMessageVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessageVO, Long> {

}
