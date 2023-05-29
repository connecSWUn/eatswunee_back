package com.swulab.eatswunee.global.common.jwt.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

// 클라이언트에게 토큰을 보내기 위한 dto
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TokenInfo {

  private String grantType; // JWT에 대한 인증타입
  private String accessToken;
  private String refreshToken;

  @Builder
  public TokenInfo(String grantType, String accessToken, String refreshToken) {
    this.grantType = grantType;
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }
}
