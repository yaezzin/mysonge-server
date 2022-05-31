package com.sook.mysonge.web;

import com.sook.mysonge.domain.user.User;
import com.sook.mysonge.domain.user.UserRepository;
import com.sook.mysonge.service.user.UserService;
import com.sook.mysonge.web.dto.user.UserLoginDto;
import com.sook.mysonge.web.dto.user.UserResponseDto;
import com.sook.mysonge.web.dto.user.UserSaveRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "User Controller", tags = "User")
@RequiredArgsConstructor
@RestController
@Slf4j
public class UserApiController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/user")
    @ApiOperation(value = "유저 등록(회원가입)", notes = "회원가입 API. 이미 회원(email)이 존재하는 경우, 0 리턴")
    public Long save(@RequestBody UserSaveRequestDto requestDto){
        Optional<User> userEmail = userRepository.findByEmail(requestDto.getEmail());
        if(userEmail.isPresent()){
            return 0L;
        } else{
            return userService.save(requestDto);
        }
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "유저 수정", notes = "유저 수정 API")
    public UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/all/users")
    @ApiOperation(value = "유저 DB 조회", notes = "유저 DB 조회 API")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인", notes = "로그인 API. 이메일과 비밀번호 매치하지 않는 경우 0 리턴")
    public Long login(@RequestBody UserLoginDto userLoginDto) {
        return userService.findByEmail(userLoginDto);
    }
}
