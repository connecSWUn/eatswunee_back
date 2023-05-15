package com.swulab.eatswunee.domain.recruit.adapter.in.web.controller;

import com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.request.AddRecruitRequest;
import com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.response.AddRecruitResponse;
import com.swulab.eatswunee.domain.recruit.application.port.in.AddRecruitUseCase;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddRecruitController {

  private final AddRecruitUseCase addRecruitUseCase;

  @PostMapping("/recruit/save")
  public ResponseEntity addRecruitContent(@RequestBody AddRecruitRequest request) {
    Long postId = addRecruitUseCase.addRecruit(request.toCommand());
    System.out.println(postId);


    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(new AddRecruitResponse(postId)));
  }

}
