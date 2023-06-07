package com.swulab.eatswunee.domain.notification.application.port.out;

import com.swulab.eatswunee.domain.notification.application.port.in.command.GetRevenueCommand;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRevenueCommand;
import java.util.List;

public interface FindRevenuePort {

  List<FindRevenueCommand> findRevenue(Long restaurantId);

}
