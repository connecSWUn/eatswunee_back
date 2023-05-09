package com.swulab.eatswunee.domain.review.domain.model;

import com.swulab.eatswunee.domain.menu.domain.model.Menu;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Review {

  private Long reviewId;
  private int score;
  private String title;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime editAt;

  private User user;
  private Menu menu;

  @Builder
  public Review(Long reviewId, int score, String title, String content,
      LocalDateTime createdAt, LocalDateTime editAt, User user,
      Menu menu) {
    this.reviewId = reviewId;
    this.score = score;
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.editAt = editAt;
    this.user = user;
    this.menu = menu;
  }
}
