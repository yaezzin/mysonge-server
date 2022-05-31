package com.sook.mysonge.web.dto.user;

import com.sook.mysonge.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserLoginDto {
    private String email;
    private String password;

    @Builder
    public UserLoginDto(String email, String password){
        this.email = email;
        this.password = password;
    }
}
