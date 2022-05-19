package com.sook.mysonge.domain.routine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
    // 오늘 루틴 성취율 반환
    //@Query

}
