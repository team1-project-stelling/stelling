package com.team1.stelling.domain.repository;

import com.team1.stelling.domain.vo.ChatMessageVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ChatMessageRepository extends JpaRepository<ChatMessageVO, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from chat_message where room_name =:roomName", nativeQuery= true)
    void deleteChat(@Param("roomName") String roomName);


}
