package com.sook.mysonge.domain.calendar;

import com.sook.mysonge.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(fetch =FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String location;

    private String context;

    @Column(nullable = false)
    private LocalDate start;

    @Column(nullable = false)
    private LocalDate end;

    @Builder
    public Calendar(Long id, String title, String color, String location,
                    String context, LocalDate start, LocalDate end) {

        this.id = id;
        this.title = title;
        this.color = color;
        this.location = location;
        this.context = context;
        this.start = start;
        this.end = end;
    }

    public void update(String title, String color, String location,
                       String context, LocalDate start, LocalDate end) {

        this.title = title;
        this.color = color;
        this.context = context;
        this.location = location;
        this.start = start;
        this.end = end;

    }
}
