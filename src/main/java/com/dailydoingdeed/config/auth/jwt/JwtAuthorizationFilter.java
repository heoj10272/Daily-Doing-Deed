package com.dailydoingdeed.config.auth.jwt;

import com.dailydoingdeed.domain.user.MyUserDetails;
import com.dailydoingdeed.domain.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.dailydoingdeed.config.auth.jwt.JwtProperties.*;
import static com.dailydoingdeed.config.auth.jwt.JwtUtils.removePrefix;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private UserRepository userRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
        super(authenticationManager);
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String jwtHeader = request.getHeader(HEADER_STRING);

        if (StringUtils.hasText(jwtHeader) && jwtHeader.startsWith(TOKEN_PREFIX)) {
            String jwtToken = removePrefix(jwtHeader);
            String username = JwtUtils.getClaim(jwtToken, "username");

            if (StringUtils.hasText(username)) {
                MyUserDetails user = new MyUserDetails(userRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException("해당 아이디를 가진 유저가 없습니다")));
                SecurityContextHolder.getContext()
                        .setAuthentication(new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()));
            }
        }
        chain.doFilter(request, response);
    }
}
