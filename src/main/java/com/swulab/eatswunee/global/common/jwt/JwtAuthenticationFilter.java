package com.swulab.eatswunee.global.common.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

// 클라이언트 요청시 jwt 인증을 하기 위한 필터. UsernamePasswordAuthenticationFilter 이전에 실행된다.

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtTokenProvider jwtTokenProvider;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    // 요청에서 토큰 받아오기
    String token = resolveToken(request);

    if (token != null && jwtTokenProvider.validateToken(token)) { // 토큰이 유효하다면
      // 토큰에서 Authentication 객체 가져옴
      Authentication authentication = jwtTokenProvider.getAuthentication(token);
      //SecurityContext 에 저장
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    // chain에 걸기
    filterChain.doFilter(request, response);

  }

  // Request Header 에서 토큰 정보 추출
  private String resolveToken(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");
    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
      return bearerToken.substring(7);
    }
    return null;
  }
}
