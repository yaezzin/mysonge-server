package com.sook.mysonge.domain.character;

import com.sook.mysonge.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "Songe")
@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "user_id",  referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String quote;

    @Builder
    public Character(String name, String quote) {
        this.name = name;
        this.quote = quote;
    }

    public void update(String name, String quote) {
        this.name = name;
        this.quote = quote;
    }

}


