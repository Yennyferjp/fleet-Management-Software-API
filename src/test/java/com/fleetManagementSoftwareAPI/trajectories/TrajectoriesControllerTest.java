package com.fleetManagementSoftwareAPI.trajectories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrajectoriesControllerTest {

    @Mock
    private TrajectoriesServices trajectoriesService;

    @InjectMocks
    private TrajectoriesController trajectoriesController;

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

    @Test
    public void testGetTrajectoriesOrderedDescByDate() {

        Trajectories trajectory1 = new Trajectories();
        trajectory1.setDate(LocalDateTime.of(2024, Month.FEBRUARY, 10, 8, 0)); // Fecha más reciente
        Trajectories trajectory2 = new Trajectories();
        trajectory2.setDate(LocalDateTime.of(2024, Month.FEBRUARY, 5, 10, 0)); // Fecha intermedia
        Trajectories trajectory3 = new Trajectories();
        trajectory3.setDate(LocalDateTime.of(2024, Month.FEBRUARY, 1, 12, 0)); // Fecha más antigua

        List<Trajectories> unorderedTrajectories = List.of(trajectory1, trajectory2, trajectory3);

        when(trajectoriesService.getTrajectories(anyLong(), any(), anyInt(), anyInt())).thenReturn(new PageImpl<>(unorderedTrajectories));

        Page<Trajectories> result = trajectoriesController.getTrajectories(6598L, LocalDate.of(2024, Month.FEBRUARY, 1), 0, 10);

        List<Trajectories> orderedTrajectories = result.getContent();
        assertTrue(orderedTrajectories.indexOf(trajectory1) < orderedTrajectories.indexOf(trajectory2));
        assertTrue(orderedTrajectories.indexOf(trajectory2) < orderedTrajectories.indexOf(trajectory3));
    }
}
