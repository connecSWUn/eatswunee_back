package com.swulab.eatswunee.domain.menu.adapter.in.web.controller;

import com.swulab.eatswunee.domain.menu.adapter.in.web.controller.dto.response.GetMenuListResponse;
import com.swulab.eatswunee.domain.menu.application.port.in.SearchMenuListUseCase;
import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuListCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import com.swulab.eatswunee.global.common.applicatioin.port.in.GetImageUrlUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchMenuListController {

  private final SearchMenuListUseCase searchMenuListUseCase;
  private final GetImageUrlUseCase getImageUrlUseCase;

  @GetMapping("/gusia/search/{restaurantId}/{keyword}")
  public ResponseEntity searchMenuList(@PathVariable Long restaurantId, @PathVariable String keyword) {

    GetMenuListCommand command = searchMenuListUseCase.searchMenuList(restaurantId, keyword);

    command.getMenuCommandList().forEach(menu -> menu.mapNameToUrl(getImageUrlUseCase.getImageUrl("menu_image/" + menu.getMenuImg())));

    GetMenuListResponse response = new GetMenuListResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

}
