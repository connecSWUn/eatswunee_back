package com.swulab.eatswunee.domain.recruit.application.service;

import com.swulab.eatswunee.domain.recruit.application.port.in.GetRecruitListUseCase;
import com.swulab.eatswunee.domain.recruit.application.port.in.RecruitListDto;
import com.swulab.eatswunee.domain.recruit.application.port.in.command.RecruitListCommand;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitListPort;
import com.swulab.eatswunee.domain.restaurant.application.port.out.ExistRestaurantPort;
import com.swulab.eatswunee.domain.restaurant.exception.RestaurantNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetRecruitListService implements GetRecruitListUseCase {

  private final FindRecruitListPort findRecruitListPort;
  private final ExistRestaurantPort existRestaurantPort;


  @Override
  public List<RecruitListDto> getRecruitList(RecruitListCommand command) {

    if (command.isAll()) {
      return findRecruitListPort.findRecruitList(null)
          .stream().map(RecruitListDto::new).collect(Collectors.toList());
    }

    if (existRestaurantPort.existRestaurant(command.getRestaurantCategory()))
      return findRecruitListPort.findRecruitList(command.getRestaurantCategory())
          .stream().map(RecruitListDto::new).collect(Collectors.toList());
    else
      throw new RestaurantNotFoundException(command.getRestaurantCategory());
  }

}
