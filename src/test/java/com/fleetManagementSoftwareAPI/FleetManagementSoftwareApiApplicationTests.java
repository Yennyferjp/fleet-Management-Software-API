package com.fleetManagementSoftwareAPI;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fleetManagementSoftwareAPI.taxis.TaxiRepository;
import com.fleetManagementSoftwareAPI.taxis.Taxis;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FleetManagementSoftwareApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TaxiRepository taxiRepository;

	@Test
	@DisplayName("Test Taxis")
	void testControllerTaxis() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/taxis?"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").isArray())
				.andExpect(jsonPath("$.content", hasSize(10)))
				.andExpect(jsonPath("$.pageable.pageNumber").value(0))
				.andExpect(jsonPath("$.pageable.pageSize").value(10))
				.andReturn();
		assertEquals("application/json", mvcResult.getResponse().getContentType());
	}

	@Test
	@DisplayName("Test Trajectories")
	void testControllerTrajectories() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/trajectories?taxi_id=6418&startDate=2008-02-02&initPage=0&pageSize=10"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(10)))
				.andReturn();

		assertEquals("application/json", mvcResult.getResponse().getContentType());
	}
}

