package com.swulab.eatswunee.domain.ordermenu.adpater.in.web.dto.request;

import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenuStatus;
import lombok.Getter;

@Getter
public class UpdateOrderMenuStatusRequest {

  public Long restaurantId;
  public Long orderId;
  public OrderMenuStatus orderMenuStatus;

  public UpdateOrderMenuStatusRequest(Long restaurantId, Long orderId, OrderMenuStatus orderMenuStatus) {
    this.restaurantId = restaurantId;
    this.orderId = orderId;
    this.orderMenuStatus = orderMenuStatus;
  }
}
