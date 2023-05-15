package com.swulab.eatswunee.global.common.adapter.web.in.dto;

import java.util.ArrayList;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SuccessResponse<T> {

  public static final String SUCCESS_MESSAGE = "성공";
  private static final String DELETE_SUCCESS_MESSAGE="삭제완료";

  private int status;
  private String title;
  private String detail;
  private T data;
  private ArrayList<String> links;

  public static SuccessResponse create201SuccessResponse() {
    return new SuccessResponse(201, "Success", SUCCESS_MESSAGE, null); // null 주의
  }

  public static <T> SuccessResponse create201SuccessResponse(T data) {
    return new SuccessResponse(201, "Success", SUCCESS_MESSAGE, data);
  }

  public static <T> SuccessResponse create200SuccessResponse(T data) {
    return new SuccessResponse(200, "Success", SUCCESS_MESSAGE, data);
  }


  public static SuccessResponse create204SuccessResponse() {
    return new SuccessResponse(204, "Success", DELETE_SUCCESS_MESSAGE, null); // null 주의
  }

  public SuccessResponse(int status, String title, String detail, T data) {
    this.status = status;
    this.title = title;
    this.detail = detail;
    this.data = data;
    this.links = new ArrayList<>();
  }

}
