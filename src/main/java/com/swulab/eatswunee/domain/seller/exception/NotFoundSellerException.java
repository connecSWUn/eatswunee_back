package com.swulab.eatswunee.domain.seller.exception;

import com.swulab.eatswunee.global.error.ErrorCode;
import com.swulab.eatswunee.global.error.exception.BusinessException;

public class NotFoundSellerException extends BusinessException {

  public NotFoundSellerException(ErrorCode errorCode,
      String message) {
    super(errorCode, message);
  }
}
