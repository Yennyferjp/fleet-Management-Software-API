package com.fleetManagementSoftwareAPI.trajectories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class LastTrajectoriesTaxisTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private TrajectoriesRepository trajectoriesRepository;
    @Test
    void validateContentSize() throws Exception {
        Pageable pageable = Pageable.ofSize(1).withPage(1);
        List<Trajectories> trajectories = new ArrayList<>();
        trajectories.add(new Trajectories());
        trajectories.add(new Trajectories());
        trajectories.add(new Trajectories());
        when(trajectoriesRepository.findLastTrajectories(pageable)).thenReturn(trajectories);

        this.mvc.perform(get("/trajectories/last")
                        .param("initPage", "1")
                        .param("pageSize", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content.length()").value(trajectories.size()))
                .andReturn();

    }


}
