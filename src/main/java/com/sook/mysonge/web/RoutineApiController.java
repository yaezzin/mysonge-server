package com.sook.mysonge.web;

import com.sook.mysonge.domain.routine.Routine;
import com.sook.mysonge.domain.routine.RoutineRepository;
import com.sook.mysonge.domain.user.User;
import com.sook.mysonge.service.routine.RoutineService;
import com.sook.mysonge.web.dto.routine.RoutineAchieveUpdateRequestDto;
import com.sook.mysonge.web.dto.routine.RoutineSaveRequestDto;
import com.sook.mysonge.web.dto.routine.RoutineUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RoutineApiController {

    private final RoutineService routineService;
    private final RoutineRepository routineRepository;

    @PostMapping("/routine")
    public Long save(@RequestBody RoutineSaveRequestDto requestDto){
        return routineService.save(requestDto);
    }

    @PutMapping("/routine/{id}")
    public Long update(@PathVariable Long id, @RequestBody RoutineUpdateRequestDto requestDto){
        return routineService.update(id, requestDto);
    }

    @PutMapping("/routine/achieve/{id}")
    public Long achieve(@PathVariable Long id, @RequestBody RoutineAchieveUpdateRequestDto requestDto){
        return routineService.achievement(id, requestDto);
    }

    @DeleteMapping("/routine/{id}")
    public Long delete(@PathVariable Long id){
        routineService.delete(id);
        return id;
    }
    @GetMapping("/routine/today")
    public List<Routine> getTodayRoutine() {
        List<Routine> byDate = routineService.findByDayOfWeek();
        return byDate;
    }

    @GetMapping("/routine/achieve")
    public String getAcheive() {
        String achievePer = routineService.findAchievePer();
        return achievePer;
    }

    @GetMapping("/all/routines")
    public List<Routine> getAllRoutines(){
        return routineRepository.findAll();
    }
}


