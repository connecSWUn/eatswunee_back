package com.swulab.eatswunee.domain.recruit.adapter.in.web.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swulab.eatswunee.domain.recruit.application.port.in.GetRecruitContentUseCase;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import com.swulab.eatswunee.domain.recruit.exception.RecruitNotFoundException;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

@DisplayName("GetRecruitContentControllerTest 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
@WebMvcTest(GetRecruitContentController.class)
@Import({ObjectMapper.class})
class GetRecruitContentControllerTest {

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private MockMvc mockMvc;


  @MockBean
  private GetRecruitContentUseCase getRecruitListUseCase;
//
//  @BeforeEach
//  public void setUp(RestDocumentationContextProvider restDocumentation) {
//    this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
////        .apply(documentationConfiguration(restDocumentation))
//        .build();
//  }


  private Recruit createRecruit() {
    return Recruit.builder()
        .recruitId(1L)
        .title("title1")
        .content("content1")
        .createdAt(LocalDateTime.now())
        .editedAt(LocalDateTime.now())
        .status(RecruitStatus.ONGOING)
        .restaurant("gusia")
        .startTime(LocalDateTime.now())
        .endTime(LocalDateTime.now())
        .user(User.builder().userId(1L).name("user1").profileUrl("profile1").build())
        .build();
  }


  @Nested
  class getRecruitContentController {


    @Test
    void 게시글이_존재할_때_응답코드_200_게시글_정보_반환() throws Exception {
      when(getRecruitListUseCase.getRecruitContent(any()))
          .thenReturn(createRecruit());

      mockMvc.perform(get("/recruit/{postId}", 1))
          .andExpect(status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
          .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Success"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.detail").value("성공"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.data.title").value("title1"));
    }

    @Test
    void 게시글이_존재하지_않을_때_응답코드_404() throws Exception {
      when(getRecruitListUseCase.getRecruitContent(any()))
          .thenThrow(new RecruitNotFoundException(""));

      mockMvc.perform(get("/recruit/{postId}", 1))
          .andExpect(status().is4xxClientError())
          .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("존재하지 않는 게시글"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(404))
          .andExpect(MockMvcResultMatchers.jsonPath("$.detail").value("주어진 게시글이 존재하지 않습니다."))
          .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(-404));
    }

  }


}