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
    private Boolean Sunday;
    private Boolean Monday;
    private Boolean Tuesday;
    private Boolean Wednesday;
    private Boolean Thursday;
    private Boolean Friday;
    private Boolean Saturday;
    private LocalTime routineTime;
    private String context;
    private Boolean achieve;

    @Builder
    public RoutineSaveRequestDto(String name, Boolean Sunday, Boolean Monday, Boolean Tuesday, Boolean Wednesday, Boolean Thursday, Boolean Friday, Boolean Saturday, LocalTime routineTime, String context, Boolean achieve){
        this.name = name;
        this.Sunday = Sunday;
        this.Monday = Monday;
        this.Tuesday = Tuesday;
        this.Wednesday = Wednesday;
        this.Thursday = Thursday;
        this.Friday = Friday;
        this.Saturday = Saturday;
        this.routineTime = routineTime;
        this.context = context;
        this.achieve = achieve;
    }

    public Routine toEntity(){
        return Routine.builder()
                .name(name)
                .Sunday(Sunday)
                .Monday(Monday)
                .Tuesday(Tuesday)
                .Wednesday(Wednesday)
                .Thursday(Thursday)
                .Friday(Friday)
                .Saturday(Saturday)
                .routineTime(routineTime)
                .context(context)
                .achieve(achieve)
                .build();
    }
}
