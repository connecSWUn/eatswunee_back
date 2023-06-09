package com.swulab.eatswunee.domain.menu.adapter.in.web.controller.dto.response;

import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuReviewListCommand;
import com.swulab.eatswunee.domain.menu.application.port.in.command.ReviewCommand;
import com.swulab.eatswunee.domain.menu.application.port.in.command.ReviewRatingCommand;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class GetMenuReviewListResponse {

  private Integer reviewCnt;
  private Long menuId;
  private String menuName;
  private String menuImg;
  private Double menuAvgRating;

  private ReviewRating reviewRating;

  private List<Review> reviews;

  public GetMenuReviewListResponse(GetMenuReviewListCommand command) {
    this.reviewCnt = command.getReviewCnt();
    this.menuId = command.getMenuId();
    this.menuName = command.getMenuName();
    this.menuImg = command.getMenuImg();
    this.menuAvgRating = command.getMenuAvgRating();
    this.reviewRating = new ReviewRating(command.getReviewRating());
    this.reviews = command.getReviews().stream().map(Review::new).toList();
  }

  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @Getter
  public class ReviewRating {

    private int score5Cnt;
    private int score4Cnt;
    private int score3Cnt;
    private int score2Cnt;
    private int score1Cnt;

    public ReviewRating(ReviewRatingCommand command) {
      this.score5Cnt = command.getScore5Cnt();
      this.score4Cnt = command.getScore4Cnt();
      this.score3Cnt = command.getScore3Cnt();
      this.score2Cnt = command.getScore2Cnt();
      this.score1Cnt = command.getScore1Cnt();
    }
  }

  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @Getter
  private class Review {

    private Long reviewId;
    private LocalDate createdAt;
    private String reviewContent;
    private int menuRating;
    private List<String> reviewImgs = new ArrayList<>();
    private Writer writer;

    public Review(ReviewCommand command) {
      this.reviewId = command.getReviewId();
      this.createdAt = command.getCreatedAt().toLocalDate();
      this.reviewContent = command.getContent();
      this.menuRating = command.getScore();
      reviewImgs.add(command.getReviewImg());
      this.writer = new Writer(command.getUser());
    }

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    private class Writer {

      private Long userId;
      private String name;
      private String profileUrl;

      public Writer(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.profileUrl = user.getProfileUrl();
      }
    }

  }


}
