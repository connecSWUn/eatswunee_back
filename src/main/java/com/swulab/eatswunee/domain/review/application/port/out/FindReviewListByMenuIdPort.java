package com.swulab.eatswunee.domain.review.application.port.out;

import com.swulab.eatswunee.domain.review.domain.model.Review;
import java.util.List;

public interface FindReviewListByMenuIdPort {

  List<Review> findReviewList(Long menuId);

}
