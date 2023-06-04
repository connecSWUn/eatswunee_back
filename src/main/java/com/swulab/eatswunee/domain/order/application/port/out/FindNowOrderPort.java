package com.swulab.eatswunee.domain.order.application.port.out;

import com.swulab.eatswunee.domain.order.application.port.out.command.FindNowOrderCommand;
import java.util.List;

public interface FindNowOrderPort {

  List<FindNowOrderCommand> findNowOrderPort(Long userId);

}
