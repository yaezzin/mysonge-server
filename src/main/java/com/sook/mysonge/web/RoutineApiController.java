package com.sook.mysonge.web;

import com.sook.mysonge.service.routine.RoutineService;
import com.sook.mysonge.web.dto.routine.RoutineSaveRequestDto;
import com.sook.mysonge.web.dto.routine.RoutineUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RoutineApiController {

    private final RoutineService routineService;

    @PostMapping("/routine")
    public Long save(@RequestBody RoutineSaveRequestDto requestDto){
        return routineService.save(requestDto);
    }

    @PutMapping("/routine/{id}")
    public Long update(@PathVariable Long id, @RequestBody RoutineUpdateRequestDto requestDto){
        return routineService.update(id, requestDto);
    }

    @DeleteMapping("/routine/{id}")
    public Long delete(@PathVariable Long id){
        routineService.delete(id);
        return id;
    }


}
