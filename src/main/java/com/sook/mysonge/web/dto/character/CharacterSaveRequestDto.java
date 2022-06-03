package com.sook.mysonge.web.dto.character;

import com.sook.mysonge.domain.character.Character;
import com.sook.mysonge.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.UnknownServiceException;

@Getter
@NoArgsConstructor
public class CharacterSaveRequestDto {

    private String name;
    private String quote;
    private Long user_id;

    @Builder
    public CharacterSaveRequestDto(String name, String quote, Long user_id) {
        this.name = name;
        this.quote = quote;
        this.user_id = user_id;
    }

    public Character toEntity() {
        return Character.builder()
                .name(name)
                .quote(quote)
                .user_id(user_id)
                .build();
    }
}