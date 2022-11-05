package com.dailydoingdeed.web;

import com.dailydoingdeed.config.auth.SecurityConfig;
import com.dailydoingdeed.docs.support.AbstractRestDocsTests;
import com.dailydoingdeed.domain.user.Role;
import com.dailydoingdeed.domain.user.User;
import com.dailydoingdeed.global.response.common.SingleResponseData;
import com.dailydoingdeed.service.UserService;
import com.dailydoingdeed.web.dto.JoinRequest;
import com.dailydoingdeed.web.dto.LoginRequest;
import com.dailydoingdeed.web.dto.LoginResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static com.dailydoingdeed.docs.support.DocumentFormatGenerator.field;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.snippet.Attributes.attributes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(
        value = UserController.class,
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = SecurityConfig.class
                )
        }
)
class UserApiControllerTest extends AbstractRestDocsTests {

    @MockBean
    protected UserService userService;

    @Test
    @DisplayName("Join User - Post /user")
    void Join() throws Exception {
        //given
        JoinRequest request = JoinRequest.builder()
                .email("user1")
                .password("user1")
                .username("user1")
                .build();

        Long id = 1L;
        given(userService.join (request)).willReturn (id);

        //when
        ResultActions action = mockMvc.perform(post ("/user/join")
                .content(toJson(request))
                .contentType(APPLICATION_JSON));

        SingleResponseData responseData = SingleResponseData.of(userService.join(request));

        //then
        action.andExpect(status().isOk())
                .andExpect(content().json(toJson(responseData)))
                .andExpect(jsonPath("$.data", is(id)))
                .andDo(restDocs.document(
                        requestFields(
                                attributes(field("title", "Post Create")),
                                fieldWithPath("email").description("email")
                                        .attributes(field("constraints", "필수 값 입니다.")),
                                fieldWithPath("password").description("password")
                                        .attributes(field("constraints", "필수 값 입니다.")),
                                fieldWithPath("username").description("username")
                                        .attributes(field("constraints", "필수 값 입니다."))
                        ),
                        responseFields(
                                fieldWithPath("statusCode").description("STATUS_CODE 200"),
                                fieldWithPath("message").description("MESSAGE"),
                                fieldWithPath("data").description("RESULT_DATA One of Value")
                        )
                ));
    }

    @Test
    @DisplayName("Login User - Post /user")
    void Login() throws Exception {
        //given
        LoginRequest request = LoginRequest.builder()
                .email("user1")
                .password("user1")
                .build();


        User user = User.builder ()
                .name ("user1")
                .email ("user1")
                .password ("user1")
                .picture (null)
                .role (Role.USER)
                .build ();
        given(userService.login (request.getEmail (), request.getPassword ())).willReturn (user);

        //when
        ResultActions action = mockMvc.perform(post ("/user/login")
                .content(toJson(request))
                .contentType(APPLICATION_JSON));

        SingleResponseData responseData = SingleResponseData.of(userService.login(request.getEmail (), request.getPassword ()));

        //then
        action.andExpect(status().isOk())
                .andExpect(content().json(toJson(responseData)))
                .andExpect(jsonPath("$.data", is(user)))
                .andDo(restDocs.document(
                        requestFields(
                                attributes(field("title", "Post Create")),
                                fieldWithPath("email").description("email")
                                        .attributes(field("constraints", "필수 값 입니다.")),
                                fieldWithPath("password").description("password")
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