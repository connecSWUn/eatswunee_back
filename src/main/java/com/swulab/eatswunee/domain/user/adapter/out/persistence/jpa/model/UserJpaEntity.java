package com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.user.domain.model.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  private String name;

  @Enumerated(EnumType.STRING)
  private Role role;

  private String profileUrl;

  private String loginId;
  private String password;

  @Builder
  public UserJpaEntity(Long userId, String name,
      Role role, String profileUrl, String loginId, String password) {
    this.userId = userId;
    this.name = name;
    this.role = role;
    this.profileUrl = profileUrl;
    this.loginId = loginId;
    this.password = password;
  }
}
