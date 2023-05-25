package com.swulab.eatswunee.domain.menu.adapter.in.web.controller;

import com.swulab.eatswunee.domain.menu.adapter.in.web.controller.dto.response.GetMenuListResponse;
import com.swulab.eatswunee.domain.menu.application.port.in.GetMenuListUseCase;
import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuListCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GetMenuListController {

  private final GetMenuListUseCase getMenuListUseCase;


  @GetMapping("/gusia/{restaurantId}")
  public ResponseEntity getMenuList(@PathVariable Long restaurantId) {

    GetMenuListCommand command = getMenuListUseCase.getMenuList(restaurantId);

    GetMenuListResponse response = new GetMenuListResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));

  }

}
