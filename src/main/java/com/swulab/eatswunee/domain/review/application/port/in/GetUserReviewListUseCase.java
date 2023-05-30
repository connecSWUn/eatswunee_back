package com.swulab.eatswunee.domain.review.application.port.in;

import com.swulab.eatswunee.domain.review.application.port.in.command.GetUserReviewCommand;
import java.util.List;

public interface GetUserReviewListUseCase {

  List<GetUserReviewCommand> getUserReviewList(Long userId);

}
