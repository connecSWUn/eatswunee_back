package com.swulab.eatswunee.domain.order.adapter.in.web.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddOrderResponse {

  private Long order_id;

  public AddOrderResponse(Long order_id) {
    this.order_id = order_id;
  }
}
