package com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.recruit.application.port.in.RecruitListDto;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RecruitListResponse {

  private String category;

  private String cursorId;

  private List<Post> post;

  public RecruitListResponse(String category, String cursorId, List<RecruitListDto> recruitList) {
    this.category = category;
    this.cursorId = cursorId;
    this.post = recruitList.stream().map(Post::new).collect(Collectors.toList());
  }

  class Post {
    private Long recruitId;

    private String title;
    private LocalDateTime createdAt;
    private RecruitStatus status;
    private String spot;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Post(RecruitListDto recruit) {
      this.recruitId = recruit.getRecruitId();
      this.title = recruit.getTitle();
      this.createdAt = recruit.getCreatedAt();
      this.status = recruit.getStatus();
      this.spot = recruit.getSpot();
      this.startTime = recruit.getStartTime();
      this.endTime = recruit.getEndTime();
    }
  }

}
