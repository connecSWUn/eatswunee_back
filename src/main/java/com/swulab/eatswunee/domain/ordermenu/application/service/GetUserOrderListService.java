package com.swulab.eatswunee.domain.ordermenu.application.service;

import com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd.UserOrderCommand;
import com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd.UserOrderMenuCommand;
import com.swulab.eatswunee.domain.order.application.port.in.GetOrderMenuUseCase;
import com.swulab.eatswunee.domain.order.application.port.out.FindOrderPort;
import com.swulab.eatswunee.domain.order.domain.model.Order;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindUserMenuOrderListPort;
import com.swulab.eatswunee.domain.review.application.port.out.FindReviewByOrderMenuIdPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetUserOrderListService implements GetOrderMenuUseCase {


  private final FindOrderPort findOrderPort;
  private final FindUserMenuOrderListPort findUserMenuOrderListPort;
  private final FindReviewByOrderMenuIdPort findReviewByOrderMenuIdPort;

  @Override
  public List<UserOrderCommand> getOrderMenuList(Long userId) {
    List<Order> orderList = findOrderPort.findAllByUserId(userId);
    List<UserOrderCommand> UserOrderCommands = orderList.stream().map(UserOrderCommand::new).toList();


    UserOrderCommands
            .forEach(
                order -> {
                  List<UserOrderMenuCommand> userMenuOrderList = findUserMenuOrderListPort.findUserMenuOrderList(
                      order.getOrderId());

                  userMenuOrderList.forEach(
                      userOrderMenuCommand -> {
                        boolean reviewByOrderMenuId = findReviewByOrderMenuIdPort.findReviewByOrderMenuId(
                            userOrderMenuCommand.getOrderMenuId());
                        userOrderMenuCommand.setIsUserWriteReview(reviewByOrderMenuId);
                      }
                  );
                  order.setOrderMenus(userMenuOrderList);
                }
            );


    return UserOrderCommands;





  }



}
