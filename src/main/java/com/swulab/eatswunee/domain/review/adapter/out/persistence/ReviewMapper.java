package com.swulab.eatswunee.domain.review.adapter.out.persistence;

import com.swulab.eatswunee.domain.menu.adapter.out.persistence.MenuMapper;
import com.swulab.eatswunee.domain.review.adapter.out.persistence.jpa.model.ReviewJpaEntity;
import com.swulab.eatswunee.domain.review.application.port.out.command.ReviewAndUserCommand;
import com.swulab.eatswunee.domain.review.domain.model.Review;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.UserMapper;
import com.swulab.eatswunee.domain.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewMapper {

  private final UserMapper userMapper;
  private final MenuMapper menuMapper;

  public Review mapToDomainEntity(ReviewJpaEntity reviewJpaEntity) {
    return Review.builder()
        .reviewId(reviewJpaEntity.getReviewId())
        .score(reviewJpaEntity.getScore())
        .title(reviewJpaEntity.getTitle())
        .content(reviewJpaEntity.getContent())
        .createdAt(reviewJpaEntity.getCreatedAt())
        .editedAt(reviewJpaEntity.getEditedAt())
        .reviewImg(reviewJpaEntity.getReviewImg())
        .user(userMapper.mapToDomainEntity(reviewJpaEntity.getUserJpaEntity()))
        .menu(menuMapper.mapToDomainEntity(reviewJpaEntity.getMenuJpaEntity()))
        .build();
  }

  public ReviewJpaEntity mapToJpaEntity(Review review) {
    return ReviewJpaEntity.builder()
        .reviewId(review.getReviewId())
        .score(review.getScore())
        .title(review.getTitle())
        .content(review.getContent())
        .createdAt(review.getCreatedAt())
        .editedAt(review.getEditedAt())
        .reviewImg(review.getReviewImg())
        .userJpaEntity(userMapper.mapToJpaEntity(review.getUser()))
        .menuJpaEntity(menuMapper.mapToJpaEntity(review.getMenu()))
        .build();
  }

  public Review mapToDomainEntity(ReviewAndUserCommand command) {
    return Review.builder()
        .reviewId(command.getReviewId())
        .score(command.getScore())
        .content(command.getContent())
        .createdAt(command.getCreatedAt())
        .editedAt(command.getEditedAt())
        .reviewImg(command.getReviewImg())
        .user(User.builder().userId(command.getUserId()).name(command.getName()).profileUrl(command.getProfileUrl()).build())
        .build();
  }
}
