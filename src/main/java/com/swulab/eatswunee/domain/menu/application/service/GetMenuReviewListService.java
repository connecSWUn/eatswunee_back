package com.swulab.eatswunee.domain.menu.application.service;

import com.swulab.eatswunee.domain.menu.application.port.in.GetMenuReviewListUseCase;
import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuReviewListCommand;
import com.swulab.eatswunee.domain.menu.application.port.out.FindMenuPort;
import com.swulab.eatswunee.domain.menu.domain.model.Menu;
import com.swulab.eatswunee.domain.review.application.port.out.FindReviewListByMenuIdPort;
import com.swulab.eatswunee.domain.review.domain.model.Review;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMenuReviewListService implements GetMenuReviewListUseCase {

  private final FindMenuPort findMenuPort;
  private final FindReviewListByMenuIdPort findReviewListByMenuIdPort;



  @Override
  public GetMenuReviewListCommand getMenuReviewList(Long menuId) {

    Menu menu = findMenuPort.findMenu(menuId);
    List<Review> reviews = findReviewListByMenuIdPort.findReviewList(menuId);
    return new GetMenuReviewListCommand(menu, reviews);
  }

}
