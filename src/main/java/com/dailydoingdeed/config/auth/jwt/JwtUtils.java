package com.dailydoingdeed.config.auth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dailydoingdeed.domain.user.MyUserDetails;
import com.dailydoingdeed.domain.user.User;

import java.util.Date;

import static com.dailydoingdeed.config.auth.jwt.JwtProperties.*;

// jwt 관련 기능
public class JwtUtils {

    // 토큰에서 원하는 정보 추출
    public static String getClaim(String jwtToken, String claim) {
        return JWT.require(Algorithm.HMAC512(SECRET))
                .build()
                .verify(jwtToken)
                .getClaim(claim)
                .asString();
    }

    // 토큰 생성
    public static String createJwtToken1(MyUserDetails userDetails){
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .withClaim("username", userDetails.getUser().getName())
                .withClaim("role", userDetails.getUser().getRole().name())
                .sign(Algorithm.HMAC512(SECRET));
    }

    // 토큰 생성
    public static String createJwtToken2(User user){
        return JWT.create()
                .withSubject(user.getName ())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .withClaim("username", user.getName())
                .withClaim("role", user.getRole().name())
                .sign(Algorithm.HMAC512(SECRET));
    }

    // 전처리 삭제
    public static String removePrefix(String jwtHeader) {
        return jwtHeader.replace(TOKEN_PREFIX, "");
    }
}
