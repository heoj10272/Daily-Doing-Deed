package com.dailydoingdeed.service;

import com.dailydoingdeed.domain.user.User;
import com.dailydoingdeed.domain.user.UserRepository;
import com.dailydoingdeed.web.dto.JoinRequest;
import com.dailydoingdeed.web.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long join(JoinRequest joinRequest) {
        return userRepository.save(joinRequest.toEntity(passwordEncoder)).getId ();
    }

    @Transactional(readOnly = true)
    public User login(String email, String password) {
        User entity = userRepository.findByEmail (email).orElseThrow(() -> new IllegalArgumentException("Not Found Such User"));
        if(passwordEncoder.matches (entity.getPassword (), password))
            return entity;
        else
            return null;
    }
}
