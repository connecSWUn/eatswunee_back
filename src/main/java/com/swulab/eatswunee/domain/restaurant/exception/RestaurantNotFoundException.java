package com.swulab.eatswunee.domain.restaurant.exception;

import com.swulab.eatswunee.global.error.ErrorCode;
import com.swulab.eatswunee.global.error.exception.BusinessException;

public class RestaurantNotFoundException extends BusinessException {

  public RestaurantNotFoundException(String name) {
    super(ErrorCode.RESTAURANT_NOT_FOUND, name);

  }
}
