package com.swulab.eatswunee.domain.chatroom.exception;

import com.swulab.eatswunee.global.error.ErrorCode;
import com.swulab.eatswunee.global.error.exception.BusinessException;

public class NotFoundChatRoomException extends BusinessException {

  public NotFoundChatRoomException(ErrorCode errorCode, String message) {
    super(errorCode, message);
  }
}
