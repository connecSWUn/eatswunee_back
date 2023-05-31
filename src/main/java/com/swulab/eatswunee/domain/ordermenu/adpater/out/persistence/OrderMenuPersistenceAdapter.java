package com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence;

import com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd.UserOrderMenuCommand;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.OrderMenuJpaRepository;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.OrderMenuJpaEntity;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindOrderMenuPort;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindUserMenuOrderListPort;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.FindRestaurantOrderMenuCommand;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenu;
import com.swulab.eatswunee.domain.review.exception.OrderMenuNotFoundException;
import com.swulab.eatswunee.global.error.ErrorCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMenuPersistenceAdapter implements FindOrderMenuPort ,
    FindUserMenuOrderListPort {

  private final OrderMenuQueryRepository orderMenuQueryRepository;
  private final OrderMenuJpaRepository orderMenuJpaRepository;
  private final OrderMenuMapper orderMenuMapper;

  @Override
  public List<FindRestaurantOrderMenuCommand> getOrderPort(Long orderId) {

    return orderMenuQueryRepository.findOrderMenu(orderId);
  }

  @Override
  public OrderMenu findOrderMenuPort(Long orderMenuId) {
    OrderMenuJpaEntity orderMenuJpaEntity = orderMenuJpaRepository.findById(orderMenuId)
        .orElseThrow(() -> new OrderMenuNotFoundException(ErrorCode.ORDER_MENU_NOT_FOUND, "주문 메뉴 아이디 "+orderMenuId+"가 존재하지 않습니다."));

    return orderMenuMapper.mapToDomainEntity(orderMenuJpaEntity);
  }


  @Override
  public List<UserOrderMenuCommand> findUserMenuOrderList(Long orderId) {

    return orderMenuQueryRepository.findUserOrderMenuList(orderId);
  }
}
