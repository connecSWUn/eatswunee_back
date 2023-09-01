package com.swulab.eatswunee.domain.user.application.port.in;

public interface UpdateUserUseCase {

  void updateUserProfileUrl(Long userId, String fileName);

}
