package com.dailydoingdeed.web.dto;

import com.dailydoingdeed.domain.user.Role;
import com.dailydoingdeed.domain.user.User;
import lombok.Getter;

@Getter
public class LoginResponse {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String picture;
    private Role role;
    private String jwtToken;

    public LoginResponse(User entity, String jwtToken){
        this.id = entity.getId();
        this.name = entity.getName ();
        this.email = entity.getEmail ();
        this.password = entity.getEmail ();
        this.picture = entity.getPicture ();
        this.role = entity.getRole ();
        this.jwtToken = jwtToken;
    }
}
