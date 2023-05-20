package com.swulab.eatswunee.domain.user.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import com.swulab.eatswunee.domain.user.application.port.out.command.WriteListCommand;
import com.swulab.eatswunee.domain.user.application.port.out.command.WriteListCommand.PostCommand;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetWriteListResponse {

  private Long userId;
  private String userName;
  private Integer postTotalCnt;
  private List<Post> posts;

  public GetWriteListResponse(WriteListCommand command) {
    this.userId = command.getUserId();
    this.userName = command.getUserName();
    this.postTotalCnt = command.getPostCnt();
    this.posts = command.getPostCommands().stream()
        .map(Post::new).toList();
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  class Post {

    private Long postId;
    private String postTitle;
    private LocalDateTime postStartTime;
    private LocalDateTime postEndTime;
    private LocalDateTime postCreatedAt;
    private RecruitStatus postRecruitStatus;

    public Post(PostCommand postCommand) {
      this.postId = postCommand.getPostId();
      this.postTitle = postCommand.getPostTitle();
      this.postStartTime = postCommand.getPostEndTime();
      this.postEndTime = postCommand.getPostEndTime();
      this.postCreatedAt = postCommand.getPostCreatedAt();
      this.postRecruitStatus = postCommand.getPostRecruitStatus();
    }
  }

}
