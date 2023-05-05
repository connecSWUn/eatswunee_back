package com.swulab.eatswunee.review.adapter.out.persistence;

import com.swulab.eatswunee.menu.adapter.out.persistence.MenuMapper;
import com.swulab.eatswunee.review.adapter.out.persistence.jpa.model.ReviewJpaEntity;
import com.swulab.eatswunee.review.domain.model.Review;
import com.swulab.eatswunee.user.adapter.out.persistence.UserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
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
        .editAt(reviewJpaEntity.getEditAt())
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
        .editAt(review.getEditAt())
        .userJpaEntity(userMapper.mapToJpaEntity(review.getUser()))
        .menuJpaEntity(menuMapper.mapToJpaEntity(review.getMenu()))
        .build();
  }


}
