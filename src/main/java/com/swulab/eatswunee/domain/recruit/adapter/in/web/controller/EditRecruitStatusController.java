package com.swulab.eatswunee.domain.recruit.adapter.in.web.controller;

import com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.request.EditRecruitContentRequest;
import com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.request.EditRecruitStatusRequest;
import com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.response.EditRecruitContentResponse;
import com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.response.EditRecruitStatusResponse;
import com.swulab.eatswunee.domain.recruit.application.port.in.EditRecruitStatusUseCase;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EditRecruitStatusController {

  private final EditRecruitStatusUseCase editRecruitStatusUseCase;


  @PostMapping("/recruit/edit")
  public ResponseEntity editRecruitStatus(@RequestBody EditRecruitStatusRequest request) {

    RecruitStatus resRecruitStatus = editRecruitStatusUseCase.editRecruitStatus(request.getRecruitId(),
        request.getRecruitStatus());

    EditRecruitStatusResponse response = new EditRecruitStatusResponse(resRecruitStatus);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

  @PostMapping("/recruit/edit/content")
  public ResponseEntity editRecruitContent(@RequestBody EditRecruitContentRequest request) {

    String resRecruitContent = editRecruitStatusUseCase.editRecruitContent(request.getRecruitId(),
            request.getRecruitContent());

    EditRecruitContentResponse response = new EditRecruitContentResponse(resRecruitContent);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

}
