package com.swulab.eatswunee.domain.user.application.port.in;

import com.swulab.eatswunee.domain.user.application.port.in.command.UserSignUpCommand;

public interface UserSignUpUseCase {

  Long signUp(UserSignUpCommand command);

}
