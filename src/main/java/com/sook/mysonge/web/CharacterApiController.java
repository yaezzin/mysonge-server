package com.sook.mysonge.web;

import com.sook.mysonge.service.character.CharacterService;
import com.sook.mysonge.web.dto.character.CharacterResponseDto;
import com.sook.mysonge.web.dto.character.CharacterSaveRequestDto;
import com.sook.mysonge.web.dto.character.CharacterUpdateRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(value = "Character Controller", tags = "Character")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CharacterApiController {

    private final CharacterService characterService;

    @ApiOperation(value = "캐릭터 조회", notes = "캐릭터 조회 API")
    @GetMapping("/character/{id}")
    public CharacterResponseDto findCharacter(@PathVariable Long id) {
        return characterService.findById(id);
    }

    @ApiOperation(value = "캐릭터 등록", notes = "캐릭터 등록 API")
    @PostMapping("/character")
    public CharacterResponseDto saveCharacter(@RequestBody CharacterSaveRequestDto requestDto) {
        return characterService.save(requestDto);
    }

    @ApiOperation(value = "캐릭터 수정", notes = "캐릭터 수정 API")
    @PutMapping("/character/{id}")
    public CharacterResponseDto updateCharacter(@PathVariable Long id, @RequestBody CharacterUpdateRequestDto requestDto) {
        return characterService.update(id, requestDto);
    }

}