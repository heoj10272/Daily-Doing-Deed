package com.dailydoingdeed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

<<<<<<< HEAD
// 서버에 대한
=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
<<<<<<< HEAD
        //내 서버가 응답할 때 json 자바스크립트 허용
        config.setAllowCredentials(true);
        //포트번호 응답 다름 허용 e. g) http://domain.com / config.addAllowedOriginPattern("*");
        config.addAllowedOrigin("*"); // url을 넣어야함?
        //헤더 값 응답 허용
        config.addAllowedHeader("*");
        //메서드 응답 허용(get/post 등)
        config.addAllowedMethod("*");
        //추가 헤더 지정(?)
        config.addExposedHeader("Authorization");
        config.addExposedHeader("refreshToken");
        //모든 url에 대하여 위 들을 적용시키겠다
=======
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
