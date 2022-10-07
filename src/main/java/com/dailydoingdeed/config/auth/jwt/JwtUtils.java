package com.dailydoingdeed.config.auth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dailydoingdeed.domain.user.MyUserDetails;

import java.util.Date;

import static com.dailydoingdeed.config.auth.jwt.JwtProperties.*;

public class JwtUtils {

    public static String getClaim(String jwtToken, String claim) {
        return JWT.require(Algorithm.HMAC512(SECRET))
                .build()
                .verify(jwtToken)
                .getClaim(claim)
                .asString();
    }

    public static String createJwtToken(MyUserDetails userDetails){
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .withClaim("username", userDetails.getUser().getName())
                .withClaim("role", userDetails.getUser().getRole().name())
                .sign(Algorithm.HMAC512(SECRET));
    }

    public static String removePrefix(String jwtHeader) {
        return jwtHeader.replace(TOKEN_PREFIX, "");
    }
}
