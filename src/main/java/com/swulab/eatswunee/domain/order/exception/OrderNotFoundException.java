package com.swulab.eatswunee.domain.order.exception;

import com.swulab.eatswunee.global.error.ErrorCode;
import com.swulab.eatswunee.global.error.exception.BusinessException;

public class OrderNotFoundException extends BusinessException {

  public OrderNotFoundException(ErrorCode errorCode,
      String message) {
    super(errorCode, message);
  }
}
