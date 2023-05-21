package com.swulab.eatswunee.domain.review.adapter.out.persistence;

import com.swulab.eatswunee.domain.review.application.port.out.FindReviewRatingByMenuIdPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewPersistenceAdapter implements FindReviewRatingByMenuIdPort {

  private final ReviewQueryRepository reviewQueryRepository;


  @Override
  public List<Integer> findMenuRatingByMenuId(Long menuId) {
    return reviewQueryRepository.findMenuRatingByMenuId(menuId);
  }
}
