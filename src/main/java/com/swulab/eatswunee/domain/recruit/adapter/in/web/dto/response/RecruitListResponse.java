package com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.recruit.application.port.in.RecruitListDto;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import com.swulab.eatswunee.domain.restaurant.domain.model.RestaurantSpot;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RecruitListResponse {

  private RestaurantSpot category;

  private String cursorId;

  private List<Post> post;

  public RecruitListResponse(RestaurantSpot category, String cursorId, List<RecruitListDto> recruitList) {
    this.category = category;
    this.cursorId = cursorId;
    this.post = recruitList.stream().map(Post::new).collect(Collectors.toList());
  }

  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @Getter
  class Post {
    @NotNull
    private Long recruitId;

    private String title;
    private LocalDateTime createdAt;
    private RecruitStatus recruitStatus;
    private String spot;
    private LocalTime startTime;
    private LocalTime endTime;

    public Post(RecruitListDto recruit) {
      this.recruitId = recruit.getRecruitId();
      this.title = recruit.getTitle();
      this.createdAt = recruit.getCreatedAt();
      this.recruitStatus = recruit.getStatus();
      this.spot = recruit.getSpot();
      this.startTime = recruit.getStartTime();
      this.endTime = recruit.getEndTime();
    }
  }

}
