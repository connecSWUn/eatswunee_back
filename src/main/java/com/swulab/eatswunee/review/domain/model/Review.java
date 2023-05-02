package com.swulab.eatswunee.review.domain.model;

import com.swulab.eatswunee.menu.domain.model.Menu;
import com.swulab.eatswunee.user.domain.model.User;
import java.time.LocalDateTime;
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

}
