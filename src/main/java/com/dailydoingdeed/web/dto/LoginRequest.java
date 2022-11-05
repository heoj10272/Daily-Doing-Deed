package com.dailydoingdeed.web.dto;

<<<<<<< HEAD
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest {
    private String email;
    private String password;

    @Builder
    public LoginRequest(String email, String password){
        this.email = email;
        this.password = password;
    }
}
=======
import lombok.Data;

@Data
public class LoginRequest {
	private String username;
	private String password;
}
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
