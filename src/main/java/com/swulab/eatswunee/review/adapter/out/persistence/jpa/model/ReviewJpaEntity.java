package com.swulab.eatswunee.review.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.menu.adapter.out.persistence.jpa.model.MenuJpaEntity;
import com.swulab.eatswunee.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReviewJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long reviewId;

  private int score;

  private String title;

  private String content;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime editAt;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserJpaEntity userJpaEntity;

  @ManyToOne
  @JoinColumn(name = "menu_id")
  private MenuJpaEntity menuJpaEntity;

  @Builder
  public ReviewJpaEntity(Long reviewId, int score, String title, String content,
      LocalDateTime createdAt, LocalDateTime editAt,
      UserJpaEntity userJpaEntity,
      MenuJpaEntity menuJpaEntity) {
    this.reviewId = reviewId;
    this.score = score;
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.editAt = editAt;
    this.userJpaEntity = userJpaEntity;
    this.menuJpaEntity = menuJpaEntity;
  }
}
