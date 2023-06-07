package com.swulab.eatswunee.domain.notification.application.port.in.command;

import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRevenueCommand;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetRevenueCommand {

  private int todayTotalRevenue;
  private int totalRevenue;

  public GetRevenueCommand(List<FindRevenueCommand> commands) {
    this.totalRevenue = commands.
        stream().mapToInt(command -> command.getMenuPrice() * command.getMenuCnt()).sum();
    LocalDateTime start = LocalDate.now().atStartOfDay();
    LocalDateTime end = LocalDate.now().atStartOfDay().plusDays(1).minusSeconds(1);

    this.todayTotalRevenue = commands.stream().filter(command -> (command.getOrderCreatedAt().isAfter(start) && command.getOrderCreatedAt().isBefore(end)))
        .mapToInt(command -> command.getMenuPrice() * command.getMenuCnt()).sum();
  }
}
