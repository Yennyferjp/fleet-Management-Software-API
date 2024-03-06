package com.fleetManagementSoftwareAPI.taxis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaxisControllerTest {

    @MockBean
    private TaxisService taxisService;

    @Autowired
    private TaxisController taxisController;

    @Test
    public void testGetTaxis() {
        int pageNumber = 0;
        int pageSize = 10;
        Page<Taxis> expectedPage = new PageImpl<>(List.of(new Taxis(), new Taxis()));

        when(taxisService.getTaxis(pageNumber, pageSize)).thenReturn(expectedPage);

        Page<Taxis> result = taxisController.getTaxis(pageNumber, pageSize);

        assertEquals(expectedPage, result);
        verify(taxisService, times(1)).getTaxis(pageNumber, pageSize);
    }
}
