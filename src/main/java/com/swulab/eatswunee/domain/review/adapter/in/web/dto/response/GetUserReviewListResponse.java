package com.swulab.eatswunee.domain.review.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.review.application.port.in.command.GetUserReviewCommand;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetUserReviewListResponse {

  private List<GetUserReviewResponse> reviews;

  public GetUserReviewListResponse(List<GetUserReviewCommand> reviews) {
    this.reviews = reviews.stream().map(GetUserReviewResponse::new).toList();
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  private class GetUserReviewResponse {

    private String restaurant_name;
    private String menu_name;
    private String review_image_url;
    private int menu_review_rating;
    private String review_content;
    private LocalDateTime review_created_at;

    public GetUserReviewResponse(GetUserReviewCommand command) {
      this.restaurant_name = command.getRestaurantName();
      this.menu_name = command.getMenuName();
      this.review_image_url = command.getReviewImageUrl();
      this.menu_review_rating = command.getMenuReviewRating();
      this.review_content = command.getReviewContent();
      this.review_created_at = command.getReviewCreatedAt();
    }
  }



}
