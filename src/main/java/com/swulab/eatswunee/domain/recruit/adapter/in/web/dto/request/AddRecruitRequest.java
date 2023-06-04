package com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.request;

import com.swulab.eatswunee.domain.recruit.application.port.in.command.AddRecruitCommand;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddRecruitRequest {

  @NotNull
  @NotEmpty
  private String title;

  private String recruit_spot;

  private LocalTime start_time;

  private LocalTime end_time;

  @NotNull
  @NotEmpty
  private String content;


  public AddRecruitRequest(String title, String recruit_spot, LocalTime start_time,
      LocalTime end_time, String content) {
    this.title = title;
    this.recruit_spot = recruit_spot;
    this.start_time = start_time;
    this.end_time = end_time;
    this.content = content;
  }

  public AddRecruitCommand toCommand(Long writer_id) {
      return new AddRecruitCommand(title, recruit_spot, start_time, end_time, content, writer_id);
  }

}
