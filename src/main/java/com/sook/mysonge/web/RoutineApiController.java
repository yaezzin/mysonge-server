package com.sook.mysonge.web;

import com.sook.mysonge.domain.routine.Routine;
import com.sook.mysonge.domain.routine.RoutineRepository;
import com.sook.mysonge.domain.user.User;
import com.sook.mysonge.service.routine.RoutineService;
import com.sook.mysonge.web.dto.routine.RoutineAchieveUpdateRequestDto;
import com.sook.mysonge.web.dto.routine.RoutineSaveRequestDto;
import com.sook.mysonge.web.dto.routine.RoutineUpdateRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Routine Controller", tags = "Routine")
@RequiredArgsConstructor
@RestController
@Slf4j
public class RoutineApiController {

    private final RoutineService routineService;
    private final RoutineRepository routineRepository;

    @PostMapping("/routine")
    @ApiOperation(value = "루틴 등록", notes = "루틴 등록 API")
    public Long save(@RequestBody RoutineSaveRequestDto requestDto){
        return routineService.save(requestDto);
    }

    @PutMapping("/routine/{id}")
    @ApiOperation(value = "루틴 수정", notes = "루틴 수정 API")
    public Long update(@PathVariable Long id, @RequestBody RoutineUpdateRequestDto requestDto){
        return routineService.update(id, requestDto);
    }

    @PutMapping("/routine/achieve/{id}")
    @ApiOperation(value = "루틴 수행 여부 수정", notes = "루틴 수행 했으면 수정 API (default == false")
    public Long achieve(@PathVariable Long id, @RequestBody RoutineAchieveUpdateRequestDto requestDto){
        return routineService.achievement(id, requestDto);
    }

    @DeleteMapping("/routine/{id}")
    @ApiOperation(value = "루틴 삭제", notes = "루틴 삭제 API")
    public Long delete(@PathVariable Long id){
        routineService.delete(id);
        return id;
    }
    @GetMapping("/routine/today")
    @ApiOperation(value = "오늘의 루틴 조회", notes = "오늘 요일에 맞는 루틴 조회 API")
    public List<Routine> getTodayRoutine() {
        List<Routine> byDate = routineService.findByDayOfWeek();
        return byDate;
    }

    @GetMapping("/routine/achieve")
    @ApiOperation(value = "루틴 수행 정도(%) 조회", notes = "루틴 수행 percentage 조회 API")
    public String getAcheive() {
        String achievePer = routineService.findAchievePer();
        return achievePer;
    }

    @GetMapping("/all/routines")
    @ApiOperation(value = "루틴 DB 조회", notes = "루틴 DB 조회 API")
    public List<Routine> getAllRoutines(){
        return routineRepository.findAll();
    }
}


