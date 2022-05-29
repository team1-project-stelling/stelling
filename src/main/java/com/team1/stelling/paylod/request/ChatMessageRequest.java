package com.team1.stelling.paylod.request;


import com.team1.stelling.domain.vo.ChatMessageVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ChatMessageRequest {
    String message;
    String chatTime;
    ChatMessageVO roomName;
    UserVO userId;
    String chatFile;
}
