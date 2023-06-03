package com.swulab.eatswunee.global.common.adapter.web.in.controller;

import com.swulab.eatswunee.global.common.adapter.web.in.dto.RequestDTO;
import com.swulab.eatswunee.global.common.application.service.FirebaseCloudMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FcmController {

  private final FirebaseCloudMessageService firebaseCloudMessageService;

  @PostMapping("/api/fcm")
  public ResponseEntity pushMessage(@RequestBody RequestDTO requestDTO) throws IOException {
    System.out.println(requestDTO.getTargetToken() + " "
        + requestDTO.getTitle() + " " + requestDTO.getBody());

    firebaseCloudMessageService.sendMessageTo(
        requestDTO.getTargetToken(),
        requestDTO.getTitle(),
        requestDTO.getBody());
    return ResponseEntity.ok().build();
  }

}

