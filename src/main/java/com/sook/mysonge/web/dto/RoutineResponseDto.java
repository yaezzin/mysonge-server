package com.sook.mysonge.web.dto;

import com.sook.mysonge.domain.routine.Routine;
import lombok.Getter;

@Getter
public class RoutineResponseDto {
    private Long id;
    private String name;
    private String routineRepeat;
    private String routineTime;
    private String context;
    private Boolean achieve;

    public RoutineResponseDto(Routine entity){
        this.name = entity.getName();
        this.routineRepeat = entity.getRoutineRepeat();
        this.routineTime = entity.getRoutineTime();
        this.context = entity.getContext();
        this.achieve = entity.getAchieve();
    }
}
