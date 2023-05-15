package com.swulab.eatswunee.domain.recruit.exception;

import com.swulab.eatswunee.global.error.ErrorCode;
import com.swulab.eatswunee.global.error.exception.BusinessException;

public class RecruitNotFoundException extends BusinessException {

  public RecruitNotFoundException(String message) {
    super(ErrorCode.RECRUIT_NOT_FOUND, message);

  }

}
