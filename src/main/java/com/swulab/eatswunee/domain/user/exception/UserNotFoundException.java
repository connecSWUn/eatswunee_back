package com.swulab.eatswunee.domain.user.exception;

import com.swulab.eatswunee.global.error.ErrorCode;
import com.swulab.eatswunee.global.error.exception.BusinessException;

public class UserNotFoundException extends BusinessException {

  public UserNotFoundException(ErrorCode errorCode, String message) {
    super(errorCode, message);
  }
}
