package com.swulab.eatswunee.domain.menu.adapter.in.web.controller;

import com.swulab.eatswunee.domain.menu.adapter.in.web.controller.dto.response.GetMenuListResponse;
import com.swulab.eatswunee.domain.menu.application.port.in.SearchMenuListUseCase;
import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuListCommand;
import com.swulab.eatswunee.domain.order.application.port.in.GetRestaurantOrderListUseCase;
import com.swulab.eatswunee.domain.order.application.port.out.FindOrderPort;
import com.swulab.eatswunee.domain.order.application.port.out.command.FindRestaurantOrderListFixCommand;
import com.swulab.eatswunee.domain.order.domain.model.Order;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import com.swulab.eatswunee.global.common.application.port.in.GetImageUrlUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchMenuListController {

  private final SearchMenuListUseCase searchMenuListUseCase;
  private final GetImageUrlUseCase getImageUrlUseCase;
  private final GetRestaurantOrderListUseCase getRestaurantOrderListUseCase;
  private final FindOrderPort findOrderPort;

  @GetMapping("/gusia/search/{restaurantId}/{keyword}")
  public ResponseEntity searchMenuList(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long restaurantId, @PathVariable String keyword) {

    GetMenuListCommand command = searchMenuListUseCase.searchMenuList(restaurantId, keyword, Long.parseLong(userDetails.getUsername()));

    command.getMenuCommandList().forEach(menu -> menu.mapNameToUrl(getImageUrlUseCase.getImageUrl("menu_image/" + menu.getMenuImg())));

    //TODO 리팩토링
    command.getOrderCommandList().forEach(
        order -> {
          Order order1 = findOrderPort.findOrder(order.getOrderId());

          List<FindRestaurantOrderListFixCommand> commands = getRestaurantOrderListUseCase.getRestaurantOrderListFix(order.getRestaurantId());// d이거 이상

          List<FindRestaurantOrderListFixCommand> tmp = commands.stream()
              .filter(menu -> menu.getOrderCreatedAt().isBefore(order1.getOrderCreatedAt())).toList();

          order.changeExpectedWaitingTime(tmp.stream().mapToInt(tmp1 -> tmp1.getMenuCnt() * 5).sum());
        }
    );

    GetMenuListResponse response = new GetMenuListResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

}
