package com.swulab.eatswunee.domain.user.application.port.out;

import com.swulab.eatswunee.domain.user.domain.model.User;

public interface FindUserPort {

  User findUser(Long userId);

}
