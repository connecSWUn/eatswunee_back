package com.swulab.eatswunee.domain.recruit.adapter.in.web.controller;

import com.swulab.eatswunee.domain.recruit.application.port.in.GetRecruitListUseCase;
import com.swulab.eatswunee.domain.recruit.application.port.in.command.RecruitListCommand;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/recruit")
@RequiredArgsConstructor
public class GetRecruitListController {

  private final GetRecruitListUseCase getRecruitListUseCase;


  @GetMapping("/recruit/list/{category}")
  public ResponseEntity GetRecruitList(@PathVariable String category) {
    List<Recruit> recruitList = getRecruitListUseCase.getRecruitList(new RecruitListCommand(category));
    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(recruitList));
  }

}
