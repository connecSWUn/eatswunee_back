package com.swulab.eatswunee.domain.notification.application.port.in;

import com.swulab.eatswunee.domain.notification.application.port.in.command.GetRevenueCommand;

public interface GetRevenueUseCase {

  GetRevenueCommand getRevenue(Long restaurantId);

}
