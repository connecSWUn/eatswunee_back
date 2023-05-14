package com.swulab.eatswunee.global.support;

import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorCodeView {
  private Map<Integer, String> errorsCode;

  public ErrorCodeView(Map<Integer, String> errorsCode) {
    this.errorsCode = errorsCode;
  }
}
