package com.sook.mysonge.service.user;

import com.sook.mysonge.domain.routine.Routine;
import com.sook.mysonge.domain.user.User;
import com.sook.mysonge.domain.user.UserRepository;
import com.sook.mysonge.web.dto.routine.RoutineResponseDto;
import com.sook.mysonge.web.dto.user.UserResponseDto;
import com.sook.mysonge.web.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

}
