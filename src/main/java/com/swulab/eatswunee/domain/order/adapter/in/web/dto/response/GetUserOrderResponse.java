package com.swulab.eatswunee.domain.order.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd.UserOrderCommand;
import com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd.UserOrderMenuCommand;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetUserOrderResponse {

  List<UserOrderCommand> orders;

  public GetUserOrderResponse(
      List<UserOrderCommand> orders) {
    this.orders = orders;
  }
}
