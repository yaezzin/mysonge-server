package com.sook.mysonge.domain.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    @Query("select c from Character c where c.user_id = :user_id")
    Character findCharacterByUser(@Param("user_id") Long user_id);
}
