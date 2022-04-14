package com.sook.mysonge.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String birthday;

    @Builder
    public User(String name, String email, String birthday){
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }
}
