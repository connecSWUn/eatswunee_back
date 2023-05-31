package com.swulab.eatswunee.domain.user.adapter.in.web.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddReviewRequest {

  private Long order_menu_id;
  private int menu_review_rating;
  private String review_image_url;
  private String review_content;

  public AddReviewRequest(Long order_menu_id, int menu_review_rating, String review_image_url,
      String review_content) {
    this.order_menu_id = order_menu_id;
    this.menu_review_rating = menu_review_rating;
    this.review_image_url = review_image_url;
    this.review_content = review_content;
  }

}
