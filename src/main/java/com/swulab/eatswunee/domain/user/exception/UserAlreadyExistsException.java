package com.swulab.eatswunee.domain.user.exception;

import com.swulab.eatswunee.global.error.ErrorCode;
import com.swulab.eatswunee.global.error.exception.BusinessException;

public class UserAlreadyExistsException extends BusinessException {

  public UserAlreadyExistsException(ErrorCode errorCode,
      String message) {
    super(errorCode, message);
  }
}
