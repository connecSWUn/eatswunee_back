package com.swulab.eatswunee.global.common.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.net.HttpHeaders;
import com.swulab.eatswunee.global.common.domain.FcmMessage;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FirebaseCloudMessageService {

  private final String API_URL = "https://fcm.googleapis.com/v1/projects/swulab-80285/messages:send";
  private final ObjectMapper objectMapper;

  // targetToken에 해당하는 디바이스로 FCM push 전송 요청(targetToken은 front에서 받는다)
  public void sendMessageTo(String targetToken, String title, String body) throws IOException {
    String message = makeMessage(targetToken, title, body);

    // fcm 서버에 요청하기
    OkHttpClient client = new OkHttpClient();
    RequestBody requestBody = RequestBody.create(message, MediaType.get("application/json; charset=utf-8"));
    Request request = new Request.Builder()
        .url(API_URL)
        .post(requestBody)
        .addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())
        .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; UTF-8")
        .build();

    Response response = client.newCall(request)
        .execute();

    System.out.println(response.body().string());
  }

  // FcmMessage 구현 후 ObjectMapper를 이용해, String으로 변환 후 반환
  private String makeMessage(String targetToken, String title, String body) throws JsonProcessingException {

    FcmMessage fcmMessage = FcmMessage.builder()
        .message(FcmMessage.Message.builder()
            .token(targetToken)
            .notification(FcmMessage.Notification.builder()
                .title(title)
                .body(body)
                .image(null)
                .build()
            )
            .build()
        )
        .validate_only(false)
        .build();

    return objectMapper.writeValueAsString(fcmMessage);
  }

  // AccessToken 발급 : AccessToken -> fcm push 요청시 사용(header에 설정하여 인증을 사용)
  private String getAccessToken() throws IOException {
    String firebaseConfigPath = "/firebase/swulab-firebase-adminsdk.json";

    GoogleCredentials googleCredentials = GoogleCredentials // 구글 Api를 사용하기 위해서 Oauth2를 이용해 인증한 대상을 나타내는 객체
        .fromStream(new ClassPathResource(firebaseConfigPath).getInputStream())
        .createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));

    googleCredentials.refreshIfExpired(); // accessToken 생성
    return googleCredentials.getAccessToken().getTokenValue(); // 토큰 값 받기
  }

}