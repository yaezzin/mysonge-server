package com.sook.mysonge.service.routine;

import com.sook.mysonge.domain.routine.Routine;
import com.sook.mysonge.domain.routine.RoutineRepository;
import com.sook.mysonge.web.dto.routine.RoutineAchieveUpdateRequestDto;
import com.sook.mysonge.web.dto.routine.RoutineResponseDto;
import com.sook.mysonge.web.dto.routine.RoutineSaveRequestDto;
import com.sook.mysonge.web.dto.routine.RoutineUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoutineService {

    private final RoutineRepository routineRepository;

    public RoutineResponseDto findById(Long id){
        Routine entity = routineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 루틴 없음. id = " + id));

        return new RoutineResponseDto(entity);
    }

    @Transactional
    public Long save (RoutineSaveRequestDto requestDto){
        return routineRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, RoutineUpdateRequestDto requestDto){
        Routine routine = routineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 루틴 없음. id = " + id));

        routine.update(requestDto.getName(), requestDto.getSunday(),requestDto.getMonday(), requestDto.getTuesday(), requestDto.getWednesday(), requestDto.getThursday(), requestDto.getFriday(), requestDto.getSaturday(), requestDto.getRoutineTime(), requestDto.getContext());

        return id;
    }

    @Transactional
    public void delete(Long id){
        Routine routine = routineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 루틴 없음. id = " + id));

        routineRepository.delete(routine);
    }

    @Transactional
    public Long achievement(Long id, RoutineAchieveUpdateRequestDto requestDto){
        Routine routine = routineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 루틴 없음. id = " + id));

        routine.achievement(requestDto.getAchieve());

        return id;
    }

    public List<Routine> findByDayOfWeek() { //요일로 조회
        List<Routine> TodayRoutineBydayOfWeek = getTodayRoutineList();
        return TodayRoutineBydayOfWeek;
    }

    public String findAchievePer() { // 요일로 조회 후 성취율 반환
        List<Routine> list = getTodayRoutineList();
        int cnt = 0;
        double result;

        for(Routine r : list) {
            if(r.getAchieve() == true) { //가져온 루틴의 성취여부가 참이면 값 증가
                cnt += 1;
            }
        }

        result = ((double)cnt /(double)list.size()) * 100.0;
        String stringResult = String.format("%.1f", result);
        return stringResult;
    }


    private List<Routine> getTodayRoutineList() {
        // calendar 유틸로 요일 받아오기 일: 1, 월:2, 화:3, 수:4, 목: 5, 금: 6, 토:7
        Calendar calendar = Calendar.getInstance();

        // 요일 받아옴
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        List<Routine> routineList = routineRepository.findAll(); // 모든 루틴 찾아옴
        List<Routine> findRoutine = new ArrayList<>();

        for(Routine r : routineList) {
            if (dayOfWeek == r.getMonday()) {
                findRoutine.add(r);
            }
            if (dayOfWeek == r.getTuesday()) {
                findRoutine.add(r);
            }
            if (dayOfWeek == r.getWednesday()) {
                findRoutine.add(r);
            }
            if (dayOfWeek == r.getThursday()) {
                findRoutine.add(r);
            }
            if (dayOfWeek == r.getFriday()) {
                findRoutine.add(r);
            }
            if (dayOfWeek == r.getSaturday()) {
                findRoutine.add(r);
            }
            if (dayOfWeek == r.getSunday()) {
                findRoutine.add(r);
            }
        }
        return findRoutine;
    }

}


