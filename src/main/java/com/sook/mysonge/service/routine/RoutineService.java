package com.sook.mysonge.service.routine;

import com.sook.mysonge.domain.routine.Routine;
import com.sook.mysonge.domain.routine.RoutineRepository;
import com.sook.mysonge.web.dto.routine.RoutineResponseDto;
import com.sook.mysonge.web.dto.routine.RoutineSaveRequestDto;
import com.sook.mysonge.web.dto.routine.RoutineUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RoutineService {

    private final RoutineRepository routineRepository;

    @Transactional
    public Long save (RoutineSaveRequestDto requestDto){
        return routineRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, RoutineUpdateRequestDto requestDto){
        Routine routine = routineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 루틴 없음. id = " + id));

        routine.update(requestDto.getName(), requestDto.getRoutineRepeat(), requestDto.getRoutineTime(), requestDto.getContext(), requestDto.getAchieve());

        return id;
    }

    @Transactional
    public void delete(Long id){
        Routine routine = routineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 루틴 없음. id = " + id));

        routineRepository.delete(routine);
    }

    public RoutineResponseDto findById(Long id){
        Routine entity = routineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 루틴 없음. id = " + id));

        return new RoutineResponseDto(entity);
    }
}
