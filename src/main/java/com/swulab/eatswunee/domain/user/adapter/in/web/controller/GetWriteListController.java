package com.swulab.eatswunee.domain.user.adapter.in.web.controller;

import com.swulab.eatswunee.domain.user.adapter.in.web.dto.response.GetWriteListResponse;
import com.swulab.eatswunee.domain.user.application.port.in.GetWriteListUseCase;
import com.swulab.eatswunee.domain.user.application.port.out.command.WriteListCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetWriteListController {

  private final GetWriteListUseCase getWriteListUseCase;

  @GetMapping("/recruit/writer/{userId}")
  public ResponseEntity getWriteList(@PathVariable Long userId) {

    WriteListCommand command = getWriteListUseCase.getWriteList(userId);
    GetWriteListResponse response = new GetWriteListResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));

  }


}
