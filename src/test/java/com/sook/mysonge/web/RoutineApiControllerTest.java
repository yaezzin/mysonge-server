package com.sook.mysonge.web;

import com.sook.mysonge.domain.routine.Routine;
import com.sook.mysonge.domain.routine.RoutineRepository;
import com.sook.mysonge.web.dto.RoutineSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"security.basic.enabled=false"})
public class RoutineApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RoutineRepository routineRepository;

    @After
    public void tearDown() throws Exception{
        routineRepository.deleteAll();
    }

    @Test
    public void 루틴_등록() throws Exception{
        //given
        String name = "루틴 이름";
        String routineRepeat = "루틴 반복";
        String routineTime = "루틴 시간";
        String context = "내용 메모";
        Boolean achieve = true;

        RoutineSaveRequestDto requestDto = RoutineSaveRequestDto.builder()
                .name(name)
                .routineRepeat(routineRepeat)
                .routineTime(routineTime)
                .context(context)
                .achieve(achieve)
                .build();

        String url = "http://localhost:" + port + "/routine";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Routine> all = routineRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);

    }
}
