package com.swulab.eatswunee.global.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ExtendWith({SpringExtension.class})
@Import({ObjectMapper.class})
public class ErrorCodeDocumentationTest {


  @Autowired
  private WebApplicationContext context;

  @Autowired
  private MockMvc mockMvc;

//
//  @BeforeEach
//  public void setUp(RestDocumentationContextProvider restDocumentation) {
//    this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
////        .apply(documentationConfiguration(restDocumentation))
//        .build();
//  }

//
//  @Test
//  @DisplayName("ErrorCode 문서화")
//  public void errorCodeDocumentation() throws Exception {
//
//    this.mockMvc.perform(get("/errors").accept(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk());
////        .andDo(document("에러코드"));
//
//  }
}