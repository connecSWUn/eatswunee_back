package com.swulab.eatswunee.domain.user.adapter.in.web.controller;

import com.swulab.eatswunee.domain.user.application.port.in.UpdateUserUseCase;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UpdateDefaultController {

    private final UpdateUserUseCase updateUserUseCase;

    @PostMapping(value = "/user/profile/default")
    public ResponseEntity UploadUserProfile(@AuthenticationPrincipal UserDetails userDetails) {

        long userId = Long.parseLong(userDetails.getUsername());
        String fileName = "user_default_profile.png";
        log.info("{}", fileName);

        updateUserUseCase.updateUserProfileUrl(userId, fileName);
        return ResponseEntity.ok(SuccessResponse.create201SuccessResponse());
    }
}
