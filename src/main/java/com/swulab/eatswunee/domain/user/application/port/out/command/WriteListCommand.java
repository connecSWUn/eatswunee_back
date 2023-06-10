package com.swulab.eatswunee.domain.user.application.port.out.command;

import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WriteListCommand {

  private Long userId;
  private String userName;
  private String profileUrl;
  private int postCnt;
  private List<PostCommand> postCommands;

  public WriteListCommand(Long userId, String userName, String profileUrl,
      List<Recruit> recruitList) {
    this.userId = userId;
    this.userName = userName;
    this.profileUrl = profileUrl;
    this.postCnt = recruitList.size();
    this.postCommands = recruitList.stream().map(PostCommand::new).toList();
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class PostCommand {

    private Long postId;
    private String postTitle;
    private LocalTime postStartTime;
    private LocalTime postEndTime;
    private LocalDateTime postCreatedAt;
    private RecruitStatus postRecruitStatus;
    private String postSpot;

    public PostCommand(Recruit recruit) {
      this.postId = recruit.getRecruitId();
      this.postTitle = recruit.getTitle();
      this.postStartTime = recruit.getStartTime();
      this.postEndTime = recruit.getEndTime();
      this.postCreatedAt = recruit.getCreatedAt();
      this.postRecruitStatus = recruit.getStatus();
      this.postSpot = recruit.getRestaurant();
    }
  }
}
