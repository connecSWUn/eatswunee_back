package com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecruitContentResponse {


  private Long post_id;
  private LocalDateTime created_at;
  private LocalDateTime edited_at;

  private String title;

  private String spot;
  private LocalTime start_time;
  private LocalTime end_time;
  private RecruitStatus recruit_status;
  private String content;

  private Writer writer;

  public RecruitContentResponse(Recruit recruit) {
    this.post_id = recruit.getRecruitId();
    this.created_at = recruit.getCreatedAt();
    this.edited_at = recruit.getEditedAt();
    this.title = recruit.getTitle();
    this.spot = recruit.getRestaurant();
    this.start_time = recruit.getStartTime();
    this.end_time = recruit.getEndTime();
    this.recruit_status = recruit.getStatus();
    this.content = recruit.getContent();
    this.writer = new Writer(recruit.getUser());
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  class Writer {

    private Long user_id;
    private String user_name;
    private String user_profile_url;

    public Writer(User user) {
      this.user_id = user.getUserId();
      this.user_name = user.getName();
      this.user_profile_url = user.getProfileUrl();
    }
  }



}
