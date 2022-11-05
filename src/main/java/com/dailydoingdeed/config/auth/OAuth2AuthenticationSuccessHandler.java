package com.dailydoingdeed.config.auth;

import com.dailydoingdeed.config.auth.jwt.JwtUtils;
import com.dailydoingdeed.domain.user.MyUserDetails;
import com.dailydoingdeed.domain.user.Role;
import com.dailydoingdeed.domain.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.dailydoingdeed.config.auth.jwt.JwtProperties.HEADER_STRING;
import static com.dailydoingdeed.config.auth.jwt.JwtProperties.TOKEN_PREFIX;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

<<<<<<< HEAD
    @Override // 로그인 성공시 정보로 토큰생성
=======
    @Override
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map<String, Object> attributes = ((DefaultOAuth2User) authentication.getPrincipal()).getAttributes();
        MyUserDetails myUserDetails = new MyUserDetails(
                User.builder()
                        .name((String) attributes.get("name"))
                        .email((String) attributes.get("email"))
                        .password("noPassword")
                        .role(Role.USER)
                        .build()
        );

<<<<<<< HEAD
        String jwtToken = TOKEN_PREFIX.concat(JwtUtils.createJwtToken1(myUserDetails));
=======
        String jwtToken = TOKEN_PREFIX.concat(JwtUtils.createJwtToken(myUserDetails));
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
        response.addHeader(HEADER_STRING, jwtToken);

        System.out.println("jwtToken = " + jwtToken);
        System.out.println("redirectUri = " + getDefaultTargetUrl());

        //localhost:8080?token=asdfasfdff
        getRedirectStrategy().sendRedirect(request, response, getDefaultTargetUrl() +"?token="+ jwtToken);
    }

}
