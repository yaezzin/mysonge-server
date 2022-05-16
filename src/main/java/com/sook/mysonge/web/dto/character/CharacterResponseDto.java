package com.sook.mysonge.web.dto.character;

import com.sook.mysonge.domain.character.Character;
import lombok.Getter;

@Getter
public class CharacterResponseDto {

    private Long id;
    private String name;
    private String quote;

    public CharacterResponseDto(Character character) {
        this.id = character.getId();
        this.name = character.getName();
        this.quote = character.getQuote();
    }
}