package com.swulab.eatswunee.domain.recruit.adapter.in.web.controller;

import com.swulab.eatswunee.domain.recruit.application.port.in.DeleteRecruitUseCase;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DelRecruitController {

  private final DeleteRecruitUseCase deleteRecruitUseCase;

  @DeleteMapping("/recruit/delete/{postId}") //204
  public ResponseEntity addRecruitContent(@PathVariable Long postId) {
    deleteRecruitUseCase.deleteRecruit(postId);
    return ResponseEntity.ok(SuccessResponse.create204SuccessResponse());
  }

}
