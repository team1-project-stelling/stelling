package com.team1.stelling.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private String chatRoomId;
    private String writer;
    private String message;
    private MessageType type;
}
