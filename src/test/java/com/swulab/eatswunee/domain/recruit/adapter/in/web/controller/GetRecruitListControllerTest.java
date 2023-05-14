package com.swulab.eatswunee.domain.recruit.adapter.in.web.controller;

import static com.swulab.eatswunee.global.Utils.ApiDocumentUtils.getDocumentRequest;
import static com.swulab.eatswunee.global.Utils.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swulab.eatswunee.domain.recruit.application.port.in.GetRecruitListUseCase;
import com.swulab.eatswunee.domain.recruit.application.port.in.RecruitListDto;
import com.swulab.eatswunee.domain.recruit.application.port.in.command.RecruitListCommand;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import com.swulab.eatswunee.global.config.ObjectMapperConfig;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@DisplayName("GetRecruitListController 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
@WebMvcTest(GetRecruitListController.class)
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@Import({ObjectMapper.class, ObjectMapperConfig.class})
class GetRecruitListControllerTest {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;


  @MockBean
  private GetRecruitListUseCase getRecruitListUseCase;

  @BeforeEach
  public void setUp(RestDocumentationContextProvider restDocumentation) {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
        .apply(documentationConfiguration(restDocumentation))
        .build();
  }


  private List<RecruitListDto> createRecruitListDtos() {

    List<RecruitListDto> recruitListDtos = new ArrayList<>();

    RecruitListDto recruitListDto1 = new RecruitListDto(1L, "제목1", LocalDateTime.now(),
        RecruitStatus.ONGOING, "구시아", LocalDateTime.now(), LocalDateTime.now());

    RecruitListDto recruitListDto2 = new RecruitListDto(2L, "제목2",
        LocalDateTime.now().minusDays(1L),
        RecruitStatus.ONGOING, "퀴즈노스", LocalDateTime.now().minusHours(1), LocalDateTime.now());

    RecruitListDto recruitListDto3 = new RecruitListDto(3L, "제목3", LocalDateTime.now(),
        RecruitStatus.ONGOING, "학생식당", LocalDateTime.now().plusDays(2),
        LocalDateTime.now().plusHours(2));

    recruitListDtos.add(recruitListDto1);
    recruitListDtos.add(recruitListDto2);
    recruitListDtos.add(recruitListDto3);

    return recruitListDtos;

  }



  @Nested
  class category_파라미터가_유효할_때 {

    @Test
    void 파라미터_값이_ALL일_때_목록반환_및_응답_200() throws Exception {

      when(getRecruitListUseCase.getRecruitList(any(RecruitListCommand.class)))
          .thenReturn(createRecruitListDtos());

      mockMvc.perform(
              get("/recruit/list/{category}", "ALL"))
          .andExpect(status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
          .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Success"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.detail").value("성공"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.data.post.length()").value(3))

          .andDo(document("파라미터 값이 유효할 때",
              getDocumentRequest(),
              getDocumentResponse(),
              pathParameters(
                  parameterWithName("category").description("식당이름")
              ),
              responseFields(
                  fieldWithPath("status").type(JsonFieldType.NUMBER).description("응답코드"),
                  fieldWithPath("title").type(JsonFieldType.STRING).description("응답 메시지"),
                  fieldWithPath("detail").type(JsonFieldType.STRING).description("응답 세부 메시지"),
                  fieldWithPath("data").type(JsonFieldType.OBJECT).description("응답 데이터"),
                  fieldWithPath("data.category").type(JsonFieldType.STRING).description("참조 링크"),
                  fieldWithPath("data.cursorId").type(JsonFieldType.STRING).description("응답코드"),
                  subsectionWithPath("data.post[]").type(JsonFieldType.ARRAY).description("게시글 정보"),
                  //The documented type of the field 'data.post.[].recruitId' is Number but the actual type is Null
                  fieldWithPath("data.post.[].recruitId").description("게시글 아이디"),
                  fieldWithPath("data.post.[].title").type(JsonFieldType.STRING).description("제목"),
                  fieldWithPath("data.post.[].createdAt").type(JsonFieldType.STRING).description("글 등록 시간"),
                  fieldWithPath("data.post.[].recruitStatus").type(JsonFieldType.STRING).description("모집 진행 여부"),
                  fieldWithPath("data.post.[].spot").type(JsonFieldType.STRING).description("밥 먹을 장소"),
                  fieldWithPath("data.post.[].startTime").type(JsonFieldType.STRING).description("밥 먹는 시작 시간"),
                  fieldWithPath("data.post.[].endTime").type(JsonFieldType.STRING).description("밥 먹는 끝 시간"),
                  fieldWithPath("links").type(JsonFieldType.NULL).description("참조 링크")
              )));

    }

    @Test
    void 파라미터_값이_존재하는_식당일_때_목록_반환_및_응답_200() {

    }



  }

  @Nested
  class category_파라미터가_유효하지_않을_때 {

    @Test
    void 파라미터_값이_null이면_응답_400() {

    }

    @Test
    void 파라미터_값이_비어있으면_응답_400() {

    }

    @Test
    void 파라미터_값이_Strin이_아니라면_응답_400() {

    }

  }

}