package com.swulab.eatswunee.domain.ordermenu.application.service;

import com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd.UserOrderMenuCommand;
import com.swulab.eatswunee.domain.order.application.port.in.GetOrderMenuUseCase;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindUserMenuOrderListPort;
import com.swulab.eatswunee.domain.review.application.port.out.FindReviewByOrderMenuIdPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetUserOrderListService implements GetOrderMenuUseCase {


  private final FindUserMenuOrderListPort findUserMenuOrderListPort;
  private final FindReviewByOrderMenuIdPort findReviewByOrderMenuIdPort;

  @Override
  public List<UserOrderMenuCommand> getOrderMenuList(Long userId) {

    List<UserOrderMenuCommand> userMenuOrderList1 = findUserMenuOrderListPort.findUserMenuOrderList(
        userId);

    userMenuOrderList1.forEach(
        userOrderMenuCommand -> {
          boolean reviewByOrderMenuId = findReviewByOrderMenuIdPort.findReviewByOrderMenuId(
              userOrderMenuCommand.getOrderMenuId());
          userOrderMenuCommand.setIsUserWriteReview(reviewByOrderMenuId);
        }
    );
//

    return userMenuOrderList1;





  }



}
