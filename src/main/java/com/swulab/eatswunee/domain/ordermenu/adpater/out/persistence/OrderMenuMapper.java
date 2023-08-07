package com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence;

import com.swulab.eatswunee.domain.menu.adapter.out.persistence.MenuMapper;
import com.swulab.eatswunee.domain.order.adapter.out.persistence.OrderMapper;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.OrderMenuJpaEntity;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderMenuMapper {


  private final MenuMapper menuMapper;
  private final OrderMapper orderMapper;

  public OrderMenu mapToDomainEntity(OrderMenuJpaEntity orderMenuJpaEntity) {
    return OrderMenu.builder()
        .orderMenuId(orderMenuJpaEntity.getOrderMenuId())
        .menuCnt(orderMenuJpaEntity.getMenuCnt())
        .orderMenuStatus(orderMenuJpaEntity.getOrderMenuStatus())
        .menu(menuMapper.mapToDomainEntity(orderMenuJpaEntity.getMenuJpaEntity()))
        .order(orderMapper.mapToDomainEntity(orderMenuJpaEntity.getOrderJpaEntity()))
        .build();
  }

  public OrderMenuJpaEntity mapToJpaEntity(OrderMenu orderMenu) {
    return OrderMenuJpaEntity.builder()
        .orderMenuId(orderMenu.getOrderMenuId())
        .menuCnt(orderMenu.getMenuCnt())
        .orderMenuStatus(orderMenu.getOrderMenuStatus())
//        .orderPrice(orderMenu.getOrderPrice())
        .menuJpaEntity(menuMapper.mapToJpaEntity(orderMenu.getMenu()))
        .orderJpaEntity(orderMapper.mapToJpaEntity(orderMenu.getOrder()))
        .build();
  }

}
