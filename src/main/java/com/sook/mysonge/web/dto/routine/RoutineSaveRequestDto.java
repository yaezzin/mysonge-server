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
    private int sunday;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private int saturday;
    private String routineTime;
    private String context;
    private Boolean achieve;

    @Builder
    public RoutineSaveRequestDto(String name, int sunday, int monday, int tuesday, int wednesday, int thursday, int friday,
                                 int saturday, String routineTime, String context, Boolean achieve){
        this.name = name;
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.routineTime = routineTime;
        this.context = context;
        this.achieve = achieve;
    }

    public Routine toEntity(){
        return Routine.builder()
                .name(name)
                .sunday(sunday)
                .monday(monday)
                .tuesday(tuesday)
                .wednesday(wednesday)
                .thursday(thursday)
                .friday(friday)
                .saturday(saturday)
                .routineTime(routineTime)
                .context(context)
                .achieve(achieve)
                .build();
    }
}
