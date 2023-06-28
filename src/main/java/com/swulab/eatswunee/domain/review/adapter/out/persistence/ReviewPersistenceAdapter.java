package com.swulab.eatswunee.domain.review.adapter.out.persistence;

import com.swulab.eatswunee.domain.review.adapter.out.persistence.jpa.ReviewJpaRepository;
import com.swulab.eatswunee.domain.review.adapter.out.persistence.jpa.model.ReviewJpaEntity;
import com.swulab.eatswunee.domain.review.application.port.out.FindReviewByOrderMenuIdPort;
import com.swulab.eatswunee.domain.review.application.port.out.FindReviewListByMenuIdPort;
import com.swulab.eatswunee.domain.review.application.port.out.FindReviewRatingByMenuIdPort;
import com.swulab.eatswunee.domain.review.application.port.out.FindUserReviewListPort;
import com.swulab.eatswunee.domain.review.application.port.out.RemoveReviewPort;
import com.swulab.eatswunee.domain.review.application.port.out.SaveReviewPort;
import com.swulab.eatswunee.domain.review.application.port.out.command.FindUserReviewCommand;
import com.swulab.eatswunee.domain.review.application.port.out.command.ReviewAndUserCommand;
import com.swulab.eatswunee.domain.review.domain.model.Review;
import com.swulab.eatswunee.domain.review.exception.ReviewNotFoundException;
import com.swulab.eatswunee.global.error.ErrorCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewPersistenceAdapter implements FindReviewRatingByMenuIdPort,
    FindReviewListByMenuIdPort, FindReviewByOrderMenuIdPort, FindUserReviewListPort,
    RemoveReviewPort, SaveReviewPort 
    {
  private final ReviewQueryRepository reviewQueryRepository;
  private final ReviewMapper reviewMapper;
  private final ReviewJpaRepository reviewJpaRepository;


  @Override
  public List<Integer> findMenuRatingByMenuId(Long menuId) {
    return reviewQueryRepository.findMenuRatingByMenuId(menuId);
  }

  @Override
  public List<Review> findReviewList(Long menuId) {
    List<ReviewAndUserCommand> commandList = reviewQueryRepository.findMenuReviewListByMenuId(menuId);

    return commandList.stream().map(reviewMapper::mapToDomainEntity).toList();
  }

  @Override
  public Boolean findReviewByOrderMenuId(Long orderMenuId) {
    List<Long> reviewByOrderMenuId = reviewQueryRepository.findReviewByOrderMenuId(orderMenuId);

    if (reviewByOrderMenuId.size() == 0) {
      return false;
    }else {
      return true;
    }
  }

  @Override
  public List<FindUserReviewCommand> findUserReviewList(Long userId) {
    return reviewQueryRepository.findUserReviewListByUserId(userId);
  }

  @Override
  public void removeReview(Long reviewId) {
    ReviewJpaEntity reviewJpaEntity = reviewJpaRepository.findById(reviewId)
        .orElseThrow(() -> new ReviewNotFoundException(ErrorCode.REVIEW_NOT_FOUND,
            "[reviewId] : " + reviewId + " 존재하지 않습니다."));

    reviewJpaRepository.delete(reviewJpaEntity);
    }

  public Long saveReview(Review review) {
    ReviewJpaEntity reviewJpaEntity = reviewMapper.mapToJpaEntity(review);
    ReviewJpaEntity savedReviewJpaEntity = reviewJpaRepository.save(reviewJpaEntity);
    return savedReviewJpaEntity.getId();

  }
}
