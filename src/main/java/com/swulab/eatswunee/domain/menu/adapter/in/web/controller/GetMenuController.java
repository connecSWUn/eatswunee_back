package com.swulab.eatswunee.domain.menu.adapter.in.web.controller;

import com.swulab.eatswunee.domain.menu.adapter.in.web.controller.dto.response.GetMenuResponse;
import com.swulab.eatswunee.domain.menu.application.port.in.GetMenuUseCase;
import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetMenuController {

  private final GetMenuUseCase getMenuUseCase;

  @GetMapping("/menu/{menuId}")
  public ResponseEntity getMenu(@PathVariable Long menuId) {

    GetMenuCommand command = getMenuUseCase.getMenu(menuId);
    GetMenuResponse response = new GetMenuResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

}
