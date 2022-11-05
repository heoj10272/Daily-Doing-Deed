package com.dailydoingdeed.config.auth;

import com.dailydoingdeed.config.auth.jwt.JwtAuthenticationFilter;
import com.dailydoingdeed.config.auth.jwt.JwtAuthorizationFilter;
import com.dailydoingdeed.domain.user.Role;
import com.dailydoingdeed.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.CorsFilter;

@Configuration
<<<<<<< HEAD
@EnableWebSecurity //웹 보안 활성화
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // @PreAuthorize 메소드단위로 추가
=======
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
    private final UserRepository userRepository;
    private final CorsFilter corsFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
<<<<<<< HEAD
        //시큐리티에 필터를 추가해준다!
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 사용하지 않기 때문에 STATELESS로 설정
=======
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
                .and()
                .addFilter(corsFilter)
                .addFilter(new JwtAuthenticationFilter(authenticationManagerBean()))
                .addFilter(new JwtAuthorizationFilter(authenticationManagerBean(), userRepository));

<<<<<<< HEAD
        // token 을 사용하는 방식이기 때문에 csrf 를 disable 합니다.
        http.csrf()
                .disable()
            // 권한 설정
            .authorizeRequests()
                .antMatchers("/posts/**").hasRole(Role.USER.name())
                .anyRequest().permitAll()
            // enable h2-console
            .and()
                .headers()
                .frameOptions()
                .sameOrigin()
                //.disable()
=======
        http.csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/posts/**").hasRole(Role.USER.name())
                .anyRequest().permitAll()
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
            .and()
                .formLogin().disable()
                .httpBasic().disable()
                .logout().logoutSuccessUrl("/")
<<<<<<< HEAD
            // 로그인
=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
            .and()
                .oauth2Login()
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService)
            .and()
                .successHandler(oAuth2AuthenticationSuccessHandler);

    }
}
