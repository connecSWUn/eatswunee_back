package com.swulab.eatswunee.domain.chatmessage.application.port.out;

import com.swulab.eatswunee.domain.chatmessage.domain.model.ChatMessage;

public interface SaveChatMessagePort {

  Long saveChatMessage(ChatMessage chatMessage);

}
