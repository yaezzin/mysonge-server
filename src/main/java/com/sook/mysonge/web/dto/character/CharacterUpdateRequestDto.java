package com.sook.mysonge.web.dto.character;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CharacterUpdateRequestDto {

    private String name;
    private String quote;

    @Builder
    public CharacterUpdateRequestDto(String name, String quote) {
        this.name = name;
        this.quote = quote;
    }
}