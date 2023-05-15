package com.swulab.eatswunee.domain.recruit.application.port.in.command;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddRecruitCommand {

  private String title;

  private String spot;

  private LocalDateTime start_time;

  private LocalDateTime end_time;

  private String content;

  private Long writer_id;

  public AddRecruitCommand(String title, String spot, LocalDateTime start_time,
      LocalDateTime end_time, String content, Long writer_id) {
    this.title = title;
    this.spot = spot;
    this.start_time = start_time;
    this.end_time = end_time;
    this.content = content;
    this.writer_id = writer_id;
  }
}
