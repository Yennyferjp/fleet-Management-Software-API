package com.fleetManagementSoftwareAPI.taxis;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TaxisControllerTest {

    @Mock
    private TaxisService taxisService;

    @InjectMocks
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
