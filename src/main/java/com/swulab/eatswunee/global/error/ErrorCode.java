package com.swulab.eatswunee.global.error;


public enum ErrorCode {
  INVALID_INPUT_VALUE("유효성 검증 실패",400, -400, "올바르지 않은 형식의 값입니다."),
  INTERNAL_SERVER_ERROR("서버 에러",500, -500, "서버 에러"),

  // 식당
  RESTAURANT_NOT_FOUND("존재하지 않는 식당", 404, -404, "주어진 식당이 존재하지 않습니다."),

  // 모집글
  RECRUIT_NOT_FOUND("존재하지 않는 게시글", 404, -404, "주어진 게시글이 존재하지 않습니다."),

  // 사용자
  USER_NOT_FOUND("존재하지 않는 사용자", 404, -404, "주어진 사용자가 존재하지 않습니다."),
  USER_ALREADY_EXISTS("이미 존재하는 사용자", 400, -400, "이미 아이디가 같은 사용자가 존재합니다."),

  // 메뉴
  MENU_NOT_FOUND("존재하지 않는 메뉴", 404, -404, "주어진 메뉴가 존재하지 않습니다."),

  // 리뷰
  REVIEW_NOT_FOUND("존재하지 않는 리뷰", 404, -404, "주어진 리뷰가 존재하지 않습니다."),

  // 주문
  ORDER_NOT_FOUND("존재하지 않는 주문", 404, -404, "주어진 주문이 존재하지 않습니다."),

  //주문 메뉴
  ORDER_MENU_NOT_FOUND("존재하지 않는 메뉴 주문", 404, -404, "주어진 주문 메뉴가 존재하지 않습니다."),

  //채팅 방
  CHATROOM_NOT_FOUND("존재하지 않는 채팅방", 404, -404, "주어진 채팅방이 존재하지 않습니다."),

  //판매자
  SELLER_NOT_FOUND("존재하지 않는 판매자", 404, -404, "주어진 판매자가 존재하지 않습니다.");


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
