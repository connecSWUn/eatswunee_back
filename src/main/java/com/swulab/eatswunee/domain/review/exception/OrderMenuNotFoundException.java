package com.swulab.eatswunee.domain.review.exception;

import com.swulab.eatswunee.global.error.ErrorCode;
import com.swulab.eatswunee.global.error.exception.BusinessException;

public class OrderMenuNotFoundException extends BusinessException {

  public OrderMenuNotFoundException(ErrorCode errorCode, String message) {
    super(errorCode, message);
  }
}
