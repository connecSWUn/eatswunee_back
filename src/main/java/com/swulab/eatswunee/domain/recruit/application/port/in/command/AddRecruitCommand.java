package com.swulab.eatswunee.domain.recruit.application.port.in.command;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddRecruitCommand {

  private String title;

  private String spot;

  private LocalTime start_time;

  private LocalTime end_time;

  private String content;

  private Long writer_id;

  public AddRecruitCommand(String title, String spot, LocalTime start_time,
      LocalTime end_time, String content, Long writer_id) {
    this.title = title;
    this.spot = spot;
    this.start_time = start_time;
    this.end_time = end_time;
    this.content = content;
    this.writer_id = writer_id;
  }
}
