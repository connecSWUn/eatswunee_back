package com.swulab.eatswunee.domain.ordermenu.adpater.in.web.dto.request;

import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenuStatus;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class UpdateOrderMenuStatusRequest {

  public Long orderMenuId;
  public OrderMenuStatus orderMenuStatus;

  public UpdateOrderMenuStatusRequest(Long orderMenuId, OrderMenuStatus orderMenuStatus) {

    this.orderMenuId = orderMenuId;
    this.orderMenuStatus = orderMenuStatus;

  }
}
