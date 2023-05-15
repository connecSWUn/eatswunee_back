package com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddRecruitResponse {

  private Long post_id;

  public AddRecruitResponse(Long post_id) {
    this.post_id = post_id;
  }
}
