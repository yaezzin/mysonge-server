package com.sook.mysonge.web.dto.user;

import com.sook.mysonge.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String name;
    private String email;
    private String birthday;

    @Builder
    public UserSaveRequestDto(String name, String email, String birthday){
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .birthday(birthday)
                .build();

    }
}
