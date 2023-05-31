package com.swulab.eatswunee.domain.review.application.service;

import com.swulab.eatswunee.domain.menu.application.port.out.FindMenuPort;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindOrderMenuPort;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenu;
import com.swulab.eatswunee.domain.review.application.port.in.AddReviewUseCase;
import com.swulab.eatswunee.domain.review.application.port.out.SaveReviewPort;
import com.swulab.eatswunee.domain.review.domain.model.Review;
import com.swulab.eatswunee.domain.user.adapter.in.web.dto.request.AddReviewRequest;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddReviewService implements AddReviewUseCase {

  private final SaveReviewPort saveReviewPort;
  private final FindUserPort findUserPort;
  private final FindOrderMenuPort findOrderMenuPort;
  private final FindMenuPort findMenuPort;


  @Override
  public Long addReview(Long userId, AddReviewRequest request) {

    User user = findUserPort.findUser(userId);
    System.out.println(" addReview addReview "+request.getOrder_menu_id());
    OrderMenu orderMenu = findOrderMenuPort.findOrderMenuPort(request.getOrder_menu_id());
    System.out.println("addReview" + orderMenu.getMenu());
    Review review = Review.builder()
        .score(request.getMenu_review_rating())
        .content(request.getReview_content())
        .reviewImg(request.getReview_image_url())
        .user(user)
        .menu(orderMenu.getMenu())
        .orderMenu(orderMenu)
        .build();

    return saveReviewPort.saveReview(review);
  }
}
