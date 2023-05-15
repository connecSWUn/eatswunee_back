package com.swulab.eatswunee.global.support;

import com.swulab.eatswunee.global.error.ErrorCode;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// error code를 전부 내려주는 controller
@RestController
@RequestMapping("/errors")
public class ErrorCodeController {

  @GetMapping
  public ResponseEntity<ErrorCodeView> getErrorCodes() {

    Map<Integer, String> errorCodes = Arrays.stream(ErrorCode.values())
        .collect(Collectors.toMap(ErrorCode::getCode, ErrorCode::getDetail));

    return new ResponseEntity<>(new ErrorCodeView(errorCodes), HttpStatus.OK);
  }
}
