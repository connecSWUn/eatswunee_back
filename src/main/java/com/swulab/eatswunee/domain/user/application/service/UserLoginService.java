package com.swulab.eatswunee.domain.user.application.service;

import com.swulab.eatswunee.domain.user.application.port.in.UserLoginUseCase;
import com.swulab.eatswunee.global.common.jwt.JwtTokenProvider;
import com.swulab.eatswunee.global.common.jwt.dto.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService implements UserLoginUseCase {

  private final AuthenticationManagerBuilder authenticationManagerBuilder;
  private final JwtTokenProvider jwtTokenProvider;

  @Override
  public TokenInfo userLogin(String memberId, String password) {
    // id, pw 기반으로 Authentication 객체 생성, 이때 객체의 authenticated 값은 false
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
        memberId, password);

    // 검증이 이루어지는 부분(사용자 비밀번호 체크)
    Authentication authenticate = authenticationManagerBuilder.getObject()
        .authenticate(authenticationToken);


    // 인증 정보를 기반으로 JWT 토큰 생성
    TokenInfo tokenInfo = jwtTokenProvider.generateToken(authenticate);

    return tokenInfo;
  }

}
