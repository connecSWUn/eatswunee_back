package com.swulab.eatswunee.domain.notification.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.notification.application.port.in.command.GetRevenueCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetRevenueResponse {

  private int today_total_revenue;
  private int total_revenue;

  public GetRevenueResponse(GetRevenueCommand command) {
    this.today_total_revenue = command.getTodayTotalRevenue();
    this.total_revenue = command.getTotalRevenue();
  }
}
