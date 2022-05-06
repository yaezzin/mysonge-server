package com.sook.mysonge.domain.routine;

import com.sook.mysonge.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column(nullable = false)
    private String name;

    // ERD에는 JSON - 바꿔야하나..?
    @Column(nullable = false)
    private String routineRepeat;

    // ERD에는 TIME
    @Column(nullable = false)
    private String routineTime;

    @Column
    private String context;

    @Column
    @ColumnDefault("false")
    private Boolean achieve;

    @Builder
    public Routine(String name, String routineRepeat, String routineTime, String context, Boolean achieve){
        this.name = name;
        this.routineRepeat = routineRepeat;
        this.routineTime = routineTime;
        this.context = context;
        this.achieve = achieve;
    }

    public void update(String name, String routineRepeat, String routineTime, String context, Boolean achieve){
        this.name = name;
        this.routineRepeat = routineRepeat;
        this.routineTime = routineTime;
        this.context = context;
        this.achieve = achieve;
    }
}
