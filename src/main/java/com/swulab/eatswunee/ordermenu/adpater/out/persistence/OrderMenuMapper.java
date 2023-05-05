package com.swulab.eatswunee.ordermenu.adpater.out.persistence;

import com.swulab.eatswunee.menu.adapter.out.persistence.MenuMapper;
import com.swulab.eatswunee.order.adapter.out.persistence.OrderMapper;
import com.swulab.eatswunee.ordermenu.adpater.out.persistence.jpa.model.OrderMenuJpaEntity;
import com.swulab.eatswunee.ordermenu.domain.model.OrderMenu;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderMenuMapper {


  private final MenuMapper menuMapper;
  private final OrderMapper orderMapper;

  public OrderMenu mapToDomainEntity(OrderMenuJpaEntity orderMenuJpaEntity) {
    return OrderMenu.builder()
        .orderMenuId(orderMenuJpaEntity.getOrderMenuId())
        .menuCnt(orderMenuJpaEntity.getMenuCnt())
        .orderPrice(orderMenuJpaEntity.getOrderPrice())
        .menu(menuMapper.mapToDomainEntity(orderMenuJpaEntity.getMenuJpaEntity()))
        .order(orderMapper.mapToDomainEntity(orderMenuJpaEntity.getOrderJpaEntity()))
        .build();
  }

  public OrderMenuJpaEntity mapToJpaEntity(OrderMenu orderMenu) {
    return OrderMenuJpaEntity.builder()
        .orderMenuId(orderMenu.getOrderMenuId())
        .menuCnt(orderMenu.getMenuCnt())
        .orderPrice(orderMenu.getOrderPrice())
        .menuJpaEntity(menuMapper.mapToJpaEntity(orderMenu.getMenu()))
        .orderJpaEntity(orderMapper.mapToJpaEntity(orderMenu.getOrder()))
        .build();
  }

}
