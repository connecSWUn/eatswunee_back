package com.swulab.eatswunee.domain.ordermenu.application.service;

import com.swulab.eatswunee.domain.ordermenu.application.port.in.GetCompletedOrderListUserCase;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindCompletedOrderListPort;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.RestaurantNowOrderListCommand;
import com.swulab.eatswunee.domain.seller.application.port.out.FindSellerPort;
import com.swulab.eatswunee.domain.seller.domain.model.Seller;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCompleteOrderListService implements GetCompletedOrderListUserCase {

  private final FindCompletedOrderListPort findCompletedOrderListPort;
  private final FindSellerPort findSellerPort;

  @Override
  public List<RestaurantNowOrderListCommand> getCompletedOrderList(Long sellerId) {

    Seller seller = findSellerPort.findSeller(sellerId);
    return findCompletedOrderListPort.findCompletedOrderList(seller.getRestaurant().getRestaurantId());
  }

}
