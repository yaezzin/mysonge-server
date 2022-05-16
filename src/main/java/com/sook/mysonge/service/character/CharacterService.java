package com.sook.mysonge.service.character;

import com.sook.mysonge.domain.character.Character;
import com.sook.mysonge.domain.character.CharacterRepository;
import com.sook.mysonge.web.dto.character.CharacterResponseDto;
import com.sook.mysonge.web.dto.character.CharacterSaveRequestDto;
import com.sook.mysonge.web.dto.character.CharacterUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Transactional
    public CharacterResponseDto save(CharacterSaveRequestDto requestDto) {
        return new CharacterResponseDto(characterRepository.save(requestDto.toEntity()));
    }

    @Transactional
    public CharacterResponseDto update(Long id, CharacterUpdateRequestDto requestDto) {
        Character character = characterRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 캐릭터 없음. id = " + id));
        character.update(requestDto.getName(), requestDto.getQuote());
        return new CharacterResponseDto(character);
    }

    public CharacterResponseDto findById(Long id) {
        Character findCharacter = characterRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 캐릭터 없음. id = " + id));
        return new CharacterResponseDto(findCharacter);
    }

}
