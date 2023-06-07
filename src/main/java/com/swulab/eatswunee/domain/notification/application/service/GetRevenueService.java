package com.swulab.eatswunee.domain.notification.application.service;

import com.swulab.eatswunee.domain.notification.application.port.in.GetRevenueUseCase;
import com.swulab.eatswunee.domain.notification.application.port.in.command.GetRevenueCommand;
import com.swulab.eatswunee.domain.notification.application.port.out.FindRevenuePort;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRevenueCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetRevenueService implements GetRevenueUseCase {

  private final FindRevenuePort findRevenuePort;

  @Override
  public GetRevenueCommand getRevenue(Long restaurantId) {
    List<FindRevenueCommand> commands = findRevenuePort.findRevenue(restaurantId);
    return new GetRevenueCommand(commands);
  }
}
