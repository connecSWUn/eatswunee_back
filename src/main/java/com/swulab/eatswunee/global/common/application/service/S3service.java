package com.swulab.eatswunee.global.common.application.service;

import com.amazonaws.services.s3.AmazonS3Client;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class S3service implements GetImageUrlUseCase {

  private final AmazonS3Client amazonS3Client;

  @Value("${cloud.aws.s3.bucket}")
  private String bucketName;

  public String getImageUrl(String resource) {
    return amazonS3Client.getUrl(bucketName, resource).toString();
  }

}
