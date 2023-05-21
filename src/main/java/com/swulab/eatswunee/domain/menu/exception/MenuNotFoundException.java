package com.swulab.eatswunee.domain.menu.exception;

import com.swulab.eatswunee.global.error.ErrorCode;
import com.swulab.eatswunee.global.error.exception.BusinessException;

public class MenuNotFoundException extends BusinessException {


  public MenuNotFoundException(ErrorCode errorCode, String message) {
    super(errorCode, message);
  }
}
