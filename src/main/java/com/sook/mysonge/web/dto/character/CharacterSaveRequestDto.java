package com.sook.mysonge.web.dto.character;

import com.sook.mysonge.domain.character.Character;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CharacterSaveRequestDto {

    private String name;
    private String quote;

    @Builder
    public CharacterSaveRequestDto(String name, String quote) {
        this.name = name;
        this.quote = quote;
    }

    public Character toEntity() {
        return Character.builder()
                .name(name)
                .quote(quote)
                .build();
    }
}