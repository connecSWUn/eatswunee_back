package com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model;

import jakarta.persistence.Entity;
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

  private String profileUrl;

  @Builder
  public UserJpaEntity(Long userId, String name, String profileUrl) {
    this.userId = userId;
    this.name = name;
    this.profileUrl = profileUrl;
  }
}
