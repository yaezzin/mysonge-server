package com.sook.mysonge.web.dto.routine;

import com.sook.mysonge.domain.routine.Routine;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class RoutineSaveRequestDto {
    private String name;
    private String routineRepeat;
    private LocalTime routineTime;
    private String context;
    private Boolean achieve;

    @Builder
    public RoutineSaveRequestDto(String name, String routineRepeat, LocalTime routineTime, String context, Boolean achieve){
        this.name = name;
        this.routineRepeat = routineRepeat;
        this.routineTime = routineTime;
        this.context = context;
        this.achieve = achieve;
    }

    public Routine toEntity(){
        return Routine.builder()
                .name(name)
                .routineRepeat(routineRepeat)
                .routineTime(routineTime)
                .context(context)
                .achieve(achieve)
                .build();
    }
}
