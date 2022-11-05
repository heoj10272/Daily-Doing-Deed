package com.dailydoingdeed.web.dto;

import com.dailydoingdeed.domain.user.Role;
import com.dailydoingdeed.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@NoArgsConstructor
public class JoinRequest {
	private String email;
	private String username;
	private String password;

	@Builder
	public JoinRequest(String email, String username, String password){
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public User toEntity(PasswordEncoder passwordEncoder) {
		return User.builder()
				.name(username)
				.email(email)
				.password(passwordEncoder.encode(password))
				.role(Role.USER)
				.build();
	}
}