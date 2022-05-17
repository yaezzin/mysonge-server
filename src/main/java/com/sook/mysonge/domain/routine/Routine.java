package com.sook.mysonge.domain.routine;

import com.sook.mysonge.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.*;

@Getter
@NoArgsConstructor
@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String routineRepeat ;

    @Column(nullable = false)
    private LocalTime routineTime;

    @Column
    private String context;

    @Column
    @ColumnDefault("false")
    private Boolean achieve;

    @Builder
    public Routine(String name, String routineRepeat, LocalTime routineTime, String context, Boolean achieve, User user){
        this.name = name;
        this.routineRepeat = routineRepeat;
        this.routineTime = routineTime;
        this.context = context;
        this.achieve = achieve;
        this.user = user;
    }

    public void update(String name, String routineRepeat, LocalTime routineTime, String context, Boolean achieve){
        this.name = name;
        this.routineRepeat = routineRepeat;
        this.routineTime = routineTime;
        this.context = context;
        this.achieve = achieve;
    }
}
