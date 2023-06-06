package com.swulab.eatswunee.domain.ordermenu.application.service;

import com.swulab.eatswunee.domain.ordermenu.application.port.in.GetNowOrderListUseCase;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindNowOrderListPort;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.RestaurantNowOrderListCommand;
import com.swulab.eatswunee.domain.seller.application.port.out.FindSellerPort;
import com.swulab.eatswunee.domain.seller.domain.model.Seller;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetNowOrderListService implements GetNowOrderListUseCase {

  private final FindNowOrderListPort findNowOrderListPort;
  private final FindSellerPort findSellerPort;

  @Override
  public List<RestaurantNowOrderListCommand> getNowOrderList(Long sellerId) {

    Seller seller = findSellerPort.findSeller(sellerId);
    return findNowOrderListPort.findNowOrderList(seller.getRestaurant().getRestaurantId());
  }
}
