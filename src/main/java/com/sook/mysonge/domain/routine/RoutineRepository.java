package com.sook.mysonge.domain.routine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoutineRepository extends JpaRepository<Routine, Long> {

    @Query("select r from Routine r where r.user_id = :user_id")
    List<Routine> findRoutineByUser(@Param("user_id") Long user_id);
}
