package com.swulab.eatswunee.domain.ordermenu.domain.model;

import com.swulab.eatswunee.domain.menu.domain.model.Menu;
import com.swulab.eatswunee.domain.order.domain.model.Order;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderMenu {

  private Long orderMenuId;
  private int menuCnt;
  private OrderMenuStatus orderMenuStatus;

  private Menu menu;
  private Order order;

  @Builder
  public OrderMenu(Long orderMenuId, int menuCnt, OrderMenuStatus orderMenuStatus, Integer orderPrice,
      Menu menu, Order order) {
    this.orderMenuId = orderMenuId;
    this.menuCnt = menuCnt;
    this.orderMenuStatus = orderMenuStatus;
//    this.orderPrice = orderPrice;
    this.menu = menu;
    this.order = order;
  }

  public void changeOrderMenuStatusTo(OrderMenuStatus orderMenuStatus) {
    this.orderMenuStatus = orderMenuStatus;
  }
}
