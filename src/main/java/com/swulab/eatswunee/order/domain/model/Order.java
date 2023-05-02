package com.swulab.eatswunee.order.domain.model;

import com.swulab.eatswunee.user.domain.model.User;
import lombok.Getter;

@Getter
public class Order {

  private Long orderId;
  private int orderNum;
  private OrderStatus orderStatus;

  private User user;

}
