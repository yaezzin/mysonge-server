package com.sook.mysonge.web;

import com.sook.mysonge.service.user.UserService;
import com.sook.mysonge.web.dto.user.UserResponseDto;
import com.sook.mysonge.web.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public Long save(@RequestBody UserSaveRequestDto requestDto){
        return userService.save(requestDto);
    }

    @GetMapping("/user/{id}")
    public UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }
}
