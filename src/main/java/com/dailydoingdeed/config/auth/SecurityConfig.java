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
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
    private final UserRepository userRepository;
    private final CorsFilter corsFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(corsFilter)
                .addFilter(new JwtAuthenticationFilter(authenticationManagerBean()))
                .addFilter(new JwtAuthorizationFilter(authenticationManagerBean(), userRepository));

        http.csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/posts/**").hasRole(Role.USER.name())
                .anyRequest().permitAll()
            .and()
                .formLogin().disable()
                .httpBasic().disable()
                .logout().logoutSuccessUrl("/")
            .and()
                .oauth2Login()
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService)
            .and()
                .successHandler(oAuth2AuthenticationSuccessHandler);

    }
}
