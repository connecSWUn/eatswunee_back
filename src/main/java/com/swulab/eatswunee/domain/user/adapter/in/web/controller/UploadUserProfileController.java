package com.swulab.eatswunee.domain.user.adapter.in.web.controller;

import com.swulab.eatswunee.domain.user.application.port.in.UpdateUserUseCase;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import com.swulab.eatswunee.global.common.application.port.in.AddImageUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UploadUserProfileController {

  private final AddImageUseCase addImageUseCase;
  private final UpdateUserUseCase updateUserUseCase;

  @PostMapping(value="/user/profile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity UploadUserProfile(@AuthenticationPrincipal UserDetails userDetails, @RequestParam(value="image") MultipartFile file) {

    long userId = Long.parseLong(userDetails.getUsername());

    String fileName = addImageUseCase.uploadImage(file);
    log.info("{}", fileName);
    updateUserUseCase.updateUserProfileUrl(userId, fileName);

    return ResponseEntity.ok(SuccessResponse.create201SuccessResponse());

  }


}
