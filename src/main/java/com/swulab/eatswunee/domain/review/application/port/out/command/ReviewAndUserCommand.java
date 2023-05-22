package com.swulab.eatswunee.domain.review.application.port.out.command;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewAndUserCommand {

  private Long reviewId;
  private int score;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime editedAt;
  private String reviewImg;

  private Long userId;
  private String name;
  private String profileUrl;

  public ReviewAndUserCommand(Long reviewId, int score, String content,
      LocalDateTime createdAt, LocalDateTime editedAt, String reviewImg, Long userId,
      String name, String profileUrl) {
    this.reviewId = reviewId;
    this.score = score;
    this.content = content;
    this.createdAt = createdAt;
    this.editedAt = editedAt;
    this.reviewImg = reviewImg;
    this.userId = userId;
    this.name = name;
    this.profileUrl = profileUrl;
  }
}
