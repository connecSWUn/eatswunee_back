package com.swulab.eatswunee.global.error;


public enum ErrorCode {
  INVALID_INPUT_VALUE("유효성 검증 실패",400, -400, "올바르지 않은 형식의 값입니다."),
  INTERNAL_SERVER_ERROR("서버 에러",500, -500, "서버 에러");

//  private final String type;
//  private final String instance;
  private final String title;
  private final int status;
  private final int code;
  private final String detail;

  ErrorCode(String title, int status, int code, String detail) {
    this.title = title;
    this.status = status;
    this.code = code;
    this.detail = detail;
  }

  public String getTitle() {
    return title;
  }

  public int getStatus() {
    return status;
  }

  public int getCode() {
    return code;
  }

  public String getDetail() {
    return detail;
  }
}
