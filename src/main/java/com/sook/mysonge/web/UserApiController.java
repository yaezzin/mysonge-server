package com.sook.mysonge.web;

import com.sook.mysonge.domain.user.User;
import com.sook.mysonge.domain.user.UserRepository;
import com.sook.mysonge.service.user.UserService;
import com.sook.mysonge.web.dto.user.UserResponseDto;
import com.sook.mysonge.web.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/user")
    public Long save(@RequestBody UserSaveRequestDto requestDto){
        return userService.save(requestDto);
    }

    @GetMapping("/user/{id}")
    public UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/all/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
