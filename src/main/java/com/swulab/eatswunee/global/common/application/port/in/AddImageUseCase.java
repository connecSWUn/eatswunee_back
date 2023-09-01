package com.swulab.eatswunee.global.common.application.port.in;

import org.springframework.web.multipart.MultipartFile;

public interface AddImageUseCase {

  String uploadImage(MultipartFile multipartFile);

}
