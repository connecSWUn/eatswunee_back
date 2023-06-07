package com.swulab.eatswunee.domain.notification.application.port.out.command;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FindRevenueCommand {

  private LocalDateTime orderCreatedAt;
  private int menuCnt;
  private int menuPrice;

  public FindRevenueCommand(LocalDateTime orderCreatedAt, int menuCnt, int menuPrice) {
    this.orderCreatedAt = orderCreatedAt;
    this.menuCnt = menuCnt;
    this.menuPrice = menuPrice;
  }

}
