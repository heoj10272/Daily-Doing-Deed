package com.dailydoingdeed.config.auth.jwt;

import com.dailydoingdeed.domain.user.MyUserDetails;
<<<<<<< HEAD
import com.dailydoingdeed.config.auth.dto.LoginRequest;
=======
import com.dailydoingdeed.web.dto.LoginRequest;
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.dailydoingdeed.config.auth.jwt.JwtProperties.*;
import static com.dailydoingdeed.config.auth.jwt.JwtUtils.*;

<<<<<<< HEAD
@RequiredArgsConstructor // jwt 인증
=======
@RequiredArgsConstructor
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager manager;

<<<<<<< HEAD
    @Override // 인증 시도
=======
    @Override
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper mapper = new ObjectMapper();
        LoginRequest loginRequestDto = null;

        try {
            loginRequestDto = mapper.readValue(request.getInputStream(), LoginRequest.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );
    }

<<<<<<< HEAD
    @Override // 인증 성공
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        response.addHeader(
                HEADER_STRING,
                TOKEN_PREFIX + createJwtToken1((MyUserDetails) authResult.getPrincipal()));
=======
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        response.addHeader(
                HEADER_STRING,
                TOKEN_PREFIX + createJwtToken((MyUserDetails) authResult.getPrincipal()));
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
    }
}
