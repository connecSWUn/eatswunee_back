package com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EditRecruitContentResponse {

    private String recruitContent;

    public EditRecruitContentResponse(
            String recruitContent) {
        this.recruitContent = recruitContent;
    }
}
