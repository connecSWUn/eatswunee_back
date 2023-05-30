package com.swulab.eatswunee.domain.review.application.port.out;

import com.swulab.eatswunee.domain.review.application.port.out.command.FindUserReviewCommand;
import java.util.List;

public interface FindUserReviewListPort {

  List<FindUserReviewCommand> findUserReviewList(Long userId);

}
