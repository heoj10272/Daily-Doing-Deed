package com.dailydoingdeed.web;

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
    }
}
