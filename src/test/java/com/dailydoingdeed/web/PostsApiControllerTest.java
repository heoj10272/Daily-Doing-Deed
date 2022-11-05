package com.dailydoingdeed.web;

import com.dailydoingdeed.config.auth.SecurityConfig;
import com.dailydoingdeed.docs.support.AbstractRestDocsTests;
<<<<<<< HEAD
import com.dailydoingdeed.domain.posts.Posts;
import com.dailydoingdeed.domain.user.Role;
import com.dailydoingdeed.domain.user.User;
import com.dailydoingdeed.global.response.common.SingleResponseData;
import com.dailydoingdeed.service.CommentService;
=======
import com.dailydoingdeed.global.response.common.SingleResponseData;
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
import com.dailydoingdeed.service.PostsService;
import com.dailydoingdeed.web.dto.PostsSaveRequest;
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
        value = PostsController.class,
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = SecurityConfig.class
                )
        }
)
<<<<<<< HEAD

=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
class PostsApiControllerTest extends AbstractRestDocsTests {

    @MockBean
    protected PostsService postsService;
<<<<<<< HEAD
    @MockBean
    protected CommentService commentService;
=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320

    @Test
    @DisplayName("save post - Post /posts")
    void savePosts() throws Exception {
        //given
<<<<<<< HEAD
        User user = User.builder()
                .name ("user1")
                .email("user1")
                .password("user1")
                .picture (null)
                .role (Role.USER)
                .build();
        PostsSaveRequest request = PostsSaveRequest.builder()
                .title("posts1")
                .content("hello world")
                .author(user)
                .build();

        Long id = 1L;
        given(postsService.save(request.toEntity ())).willReturn(1L);

        //when
        ResultActions action = mockMvc.perform(post("/posts")
                .content(toJson(request))
                .contentType(APPLICATION_JSON));

        SingleResponseData responseData = SingleResponseData.of(postsService.save(request.toEntity ()));
=======
        PostsSaveRequest request = PostsSaveRequest.builder()
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
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320

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
<<<<<<< HEAD

=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
}