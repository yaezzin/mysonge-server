package com.sook.mysonge.web.dto.character;

import com.sook.mysonge.domain.character.Character;
import com.sook.mysonge.domain.user.User;
import lombok.Getter;

@Getter
public class CharacterResponseDto {
    private Long id;
    private String name;
    private String quote;
    private Long user_id;

    public CharacterResponseDto(Character character) {
        this.id = character.getId();
        this.name = character.getName();
        this.quote = character.getQuote();
        this.user_id = character.getUser_id();
    }
}