package com.sook.mysonge.service.user;

import com.sook.mysonge.domain.user.User;
import com.sook.mysonge.domain.user.UserRepository;
import com.sook.mysonge.web.dto.user.UserLoginDto;
import com.sook.mysonge.web.dto.user.UserResponseDto;
import com.sook.mysonge.web.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save (UserSaveRequestDto requestDto){
        return userRepository.save(requestDto.toEntity()).getId();
    }

    public UserResponseDto findById(Long id){
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저 없음. id = " + id));

        return new UserResponseDto(entity);
    }

    public Long findByEmail(UserLoginDto userLoginDto){
        User entity = userRepository.findByEmail(userLoginDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저 없음. email = " + userLoginDto.getEmail()));

        if(entity.getPassword().equals(userLoginDto.getPassword())){
            return entity.getId();
        }
        else{
            return 0L;
        }
    }
}
