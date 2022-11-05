package com.dailydoingdeed.web.dto;

import com.dailydoingdeed.domain.user.Role;
import com.dailydoingdeed.domain.user.User;
<<<<<<< HEAD
import lombok.Builder;
=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@NoArgsConstructor
public class JoinRequest {
	private String email;
	private String username;
	private String password;

<<<<<<< HEAD
	@Builder
	public JoinRequest(String email, String username, String password){
		this.email = email;
		this.username = username;
		this.password = password;
	}

=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
	public User toEntity(PasswordEncoder passwordEncoder) {
		return User.builder()
				.name(username)
				.email(email)
				.password(passwordEncoder.encode(password))
				.role(Role.USER)
				.build();
	}
}