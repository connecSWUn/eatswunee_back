package com.swulab.eatswunee.ordermenu;

import com.swulab.eatswunee.menu.domain.model.Menu;
import com.swulab.eatswunee.order.domain.model.Order;
import lombok.Getter;

@Getter
public class OrderMenu {

  private Long orderMenuId;
  private int menuCnt;
  private Integer orderPrice; // 주문 가격

  private Menu menu;
  private Order order;

}
