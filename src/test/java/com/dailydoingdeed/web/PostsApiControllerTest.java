package com.dailydoingdeed.web;

import com.dailydoingdeed.config.auth.SecurityConfig;
import com.dailydoingdeed.docs.support.AbstractRestDocsTests;
import com.dailydoingdeed.global.response.common.SingleResponseData;
import com.dailydoingdeed.posts.PostsService;
import com.dailydoingdeed.web.dto.PostsSaveRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.web.servlet.ResultActions;

import static com.dailydoingdeed.docs.support.DocumentFormatGenerator.field;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.snippet.Attributes.attributes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(
        value = PostsApiController.class,
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = SecurityConfig.class
                )
        }
)
class PostsApiControllerTest extends AbstractRestDocsTests {

    @MockBean
    protected PostsService postsService;

    @Test
    @DisplayName("save post - Post /posts")
    void savePosts() throws Exception {
        //given
        PostsSaveRequestDto request = PostsSaveRequestDto.builder()
                .title("posts1")
                .content("hello world")
                .author("user1")
                .build();

        Long id = 1L;
        given(postsService.save(request)).willReturn(1L);
        //when
        ResultActions action = mockMvc.perform(post("/api/v1/posts")
                .content(toJson(request))
                .contentType(APPLICATION_JSON));

        SingleResponseData responseData = SingleResponseData.of(postsService.save(request));

        //then
        action.andExpect(status().isOk())
                .andExpect(content().json(toJson(responseData)))
                .andExpect(jsonPath("$.data", is(1)))
                .andDo(restDocs.document(
                        requestFields(
                                attributes(field("title", "Post Create")),
                                fieldWithPath("title").description("title")
                                        .attributes(field("constraints", "필수 값 입니다.")),
                                fieldWithPath("content").description("content")
                                        .attributes(field("constraints", "필수 값 입니다.")),
                                fieldWithPath("author").description("author")
                                        .attributes(field("constraints", "필수 값 입니다."))
                        ),
                        responseFields(
                                fieldWithPath("statusCode").description("STATUS_CODE 200"),
                                fieldWithPath("message").description("MESSAGE"),
                                fieldWithPath("data").description("RESULT_DATA One of Value")
                        )
                ));
    }
}