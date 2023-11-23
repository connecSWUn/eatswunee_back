package com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EditRecruitContentRequest {
    private Long recruitId;
    private String recruitContent;

    public EditRecruitContentRequest(Long recruitId,
                                    String recruitContent) {
        this.recruitId = recruitId;
        this.recruitContent = recruitContent;
    }
}
