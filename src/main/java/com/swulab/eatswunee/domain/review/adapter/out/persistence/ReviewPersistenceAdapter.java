package com.swulab.eatswunee.domain.review.adapter.out.persistence;

import com.swulab.eatswunee.domain.review.application.port.out.FindReviewByOrderMenuIdPort;
import com.swulab.eatswunee.domain.review.application.port.out.FindReviewListByMenuIdPort;
import com.swulab.eatswunee.domain.review.application.port.out.FindReviewRatingByMenuIdPort;
import com.swulab.eatswunee.domain.review.application.port.out.command.ReviewAndUserCommand;
import com.swulab.eatswunee.domain.review.domain.model.Review;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewPersistenceAdapter implements FindReviewRatingByMenuIdPort,
    FindReviewListByMenuIdPort, FindReviewByOrderMenuIdPort {

  private final ReviewQueryRepository reviewQueryRepository;
  private final ReviewMapper reviewMapper;


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
}
