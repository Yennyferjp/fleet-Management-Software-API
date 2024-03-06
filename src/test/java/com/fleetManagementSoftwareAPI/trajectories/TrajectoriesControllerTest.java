package com.fleetManagementSoftwareAPI.trajectories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TrajectoriesControllerTest {

    @MockBean
    private TrajectoriesServices trajectoriesService;

    @Autowired
    private TrajectoriesController trajectoriesController;

    @MockBean
    private TrajectoriesRepository trajectoriesRepository;

    @Test
    public void testGetTrajectoriesWithValidInput() {
        Long taxi_id = 6598L;
        LocalDate startDate = LocalDate.of(2008, Month.FEBRUARY, 2);
        int pageNumber = 0;
        int pageSize = 10;
        Page<Trajectories> expectedPage = new PageImpl<>(List.of(new Trajectories(), new Trajectories(), new Trajectories()));

        when(trajectoriesService.getTrajectories(taxi_id, startDate.atStartOfDay(), pageNumber, pageSize)).thenReturn(expectedPage);

        Page<Trajectories> result = trajectoriesController.getTrajectories(taxi_id, startDate, pageNumber, pageSize);

        assertEquals(expectedPage, result);
        verify(trajectoriesService, times(1)).getTrajectories(taxi_id, startDate.atStartOfDay(), pageNumber, pageSize);
    }

}
