package com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.request;

import com.swulab.eatswunee.domain.recruit.application.port.in.command.AddRecruitCommand;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddRecruitRequest {

  @NotNull
  @NotEmpty
  private String title;

  private String spot;

  private String start_time;

  private String end_time;

  @NotNull
  @NotEmpty
  private String content;

  @NotNull
  @NotEmpty
  private Long writer_id;


  public AddRecruitRequest(String title, String spot, String start_time,
      String end_time, String content, Long writer_id) {
    this.title = title;
    this.spot = spot;
    this.start_time = start_time;
    this.end_time = end_time;
    this.content = content;
    this.writer_id = writer_id;
  }

  public AddRecruitCommand toCommand() {

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
      return new AddRecruitCommand(title, spot,
          LocalTime.parse(start_time, formatter), LocalTime.parse(end_time, formatter),
          content, writer_id);
  }

}
