package com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.user.domain.model.Role;
import com.swulab.eatswunee.global.common.domain.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Table(name = "user")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "user_id")),
    @AttributeOverride(name = "createdAt", column = @Column(name = "user_created_at"))
})
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJpaEntity extends BaseEntity {

  private String name;

  @Enumerated(EnumType.STRING)
  private Role role;

  private String profileUrl;

  private String loginId;
  private String password;

  private String fcmToken;

  public UserJpaEntity(Long userId, String name, LocalDateTime createdAt,
      Role role, String profileUrl, String loginId, String password, String fcmToken) {
    super(userId, createdAt);
    this.name = name;
    this.role = role;
    this.profileUrl = profileUrl;
    this.loginId = loginId;
    this.password = password;
    this.fcmToken = fcmToken;
  }
}
