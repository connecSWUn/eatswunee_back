package com.swulab.eatswunee.global.common.jwt;

import com.swulab.eatswunee.global.common.jwt.dto.TokenInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

//JWT 토큰 생성, 토큰 복호화 및 정보 추, 토큰의 유효성 검증
@Slf4j
@Component
public class JwtTokenProvider {

  private final Key key;

  public JwtTokenProvider(@Value("${jwt.secret}") String secretKey) {
    byte[] keyBytes = Decoders.BASE64.decode(secretKey); // 시크릿 키 복호화
    this.key = Keys.hmacShaKeyFor(keyBytes); // key 객체로 만듦
  }

  // 토큰 생성
  public TokenInfo generateToken(Authentication authentication) { // 인증된 객체 받기

    // 인증된 객체에서 권한(인가) 가져오기 그 후 승인된 권한들로 묶어서 ,를 이용해 문자열 만들기
    String authorities = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));

    long now = (new Date()).getTime();
    Date accessTokenExpiresIn = new Date(now + (86400000 * 14));

    // accessToken 생성
    String accessToken = Jwts.builder()
        .setSubject(authentication.getName()) //
        .claim("auth", authorities)
        .setExpiration(accessTokenExpiresIn)
        .signWith(key, SignatureAlgorithm.HS256) // 서명
        .compact();

    // refreshToken 생성
    String refreshToken = Jwts.builder()
        .setExpiration(new Date(now + (86400000 * 14)))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();

    // jwt 토큰 생성
    return TokenInfo.builder()
        .grantType("Bearer") // JWT에 대한 인증 타입
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .build();
  }

  // 유효한 토큰이라면 인증된 객체 가져오기
  public Authentication getAuthentication(String accessToken) {
    Claims claims = parseClaims(accessToken); // 토큰 복호화

    if (claims.get("auth") == null) {
      throw new RuntimeException("권한 정보가 없는 토큰입니다.");
    }

    // 권한 정보 가져오기
    Collection<? extends GrantedAuthority> authorities =
        Arrays.stream(claims.get("auth").toString().split(","))
            .map(SimpleGrantedAuthority::new).toList();

    // UserDetails 객체를 만들어서 Authentication 리턴
    UserDetails principal = new User(claims.getSubject(), "", authorities);
    return new UsernamePasswordAuthenticationToken(principal, "", authorities);
  }

  // 토큰 정보 검증
  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;
    } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
      log.info("Invalid JWT Token", e);
    } catch (ExpiredJwtException e) {
      log.info("Expired JWT Token", e);
    } catch (UnsupportedJwtException e) {
      log.info("Unsupported JWT Token", e);
    } catch (IllegalArgumentException e) {
      log.info("JWT claims string is empty.", e);
    }
    return false;
  }

  // 토큰 복호화
  private Claims parseClaims(String accessToken) {
    try {
      return Jwts.parserBuilder()
          .setSigningKey(key).build()
          .parseClaimsJws(accessToken)
          .getBody();
    } catch (ExpiredJwtException e) {
      return e.getClaims();
    }
  }
}
