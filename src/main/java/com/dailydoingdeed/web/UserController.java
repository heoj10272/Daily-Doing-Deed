package com.dailydoingdeed.web;

<<<<<<< HEAD
import com.dailydoingdeed.config.auth.jwt.JwtUtils;
import com.dailydoingdeed.domain.user.User;
import com.dailydoingdeed.global.response.common.SingleResponseData;
import com.dailydoingdeed.service.UserService;
import com.dailydoingdeed.web.dto.JoinRequest;
import com.dailydoingdeed.web.dto.LoginRequest;
import com.dailydoingdeed.web.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static com.dailydoingdeed.config.auth.jwt.JwtProperties.HEADER_STRING;
import static com.dailydoingdeed.config.auth.jwt.JwtProperties.TOKEN_PREFIX;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 소셜 가입
    @PostMapping("/join")
    public SingleResponseData<Long> join(@RequestBody JoinRequest joinRequest){
        return SingleResponseData.of(userService.join(joinRequest));
    }

    // 로그인
    @PostMapping("/login")
    public SingleResponseData<LoginResponse> login(HttpServletResponse response, @RequestBody LoginRequest loginRequest){
        User entity = userService.login(loginRequest.getEmail (), loginRequest.getPassword ());
        if(entity == null){
            throw new IllegalArgumentException("Incorrect Password");
        }

        String jwtToken = TOKEN_PREFIX.concat(JwtUtils.createJwtToken2(entity));
        response.addHeader(HEADER_STRING, jwtToken);

        LoginResponse loginResponse = new LoginResponse (entity, jwtToken);
        return SingleResponseData.of(loginResponse);
=======
import com.dailydoingdeed.domain.user.UserRepository;
import com.dailydoingdeed.global.response.common.SingleResponseData;
import com.dailydoingdeed.web.dto.JoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostMapping("/join")
    public SingleResponseData<String> join(@RequestBody JoinRequest joinRequest){
        userRepository.save(joinRequest.toEntity(passwordEncoder));
        return SingleResponseData.of("save success");
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
    }
}
