package com.sook.mysonge.domain.routine;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoutineRepositoryTest {

    @Autowired
    RoutineRepository routineRepository;

    @After
    public void cleanup(){
        routineRepository.deleteAll();
    }

    @Test
    public void 루틴_불러오기(){
        //given
        String name = "routine name";
        String repeat = "routine repeat";
        String time = "routine time";
        String context = "routine context";
        Boolean achieve = Boolean.FALSE;

        routineRepository.save(Routine.builder()
                .name(name)
                .routineRepeat(repeat)
                .routineTime(time)
                .context(context)
                .achieve(achieve)
                .build());

        //when
        List<Routine> routineList = routineRepository.findAll();

        //then
        Routine routine = routineList.get(0);
        assertThat(routine.getName()).isEqualTo(name);
        assertThat(routine.getRoutineRepeat()).isEqualTo(repeat);
        assertThat(routine.getRoutineTime()).isEqualTo(time);
    }
}
