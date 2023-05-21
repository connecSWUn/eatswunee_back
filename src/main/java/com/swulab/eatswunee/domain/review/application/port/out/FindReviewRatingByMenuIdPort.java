package com.swulab.eatswunee.domain.review.application.port.out;

import java.util.List;

public interface FindReviewRatingByMenuIdPort {

  List<Integer> findMenuRatingByMenuId(Long menuId);

}
