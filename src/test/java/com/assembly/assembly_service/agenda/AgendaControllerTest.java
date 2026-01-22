package com.assembly.assembly_service.agenda;

import com.assembly.assembly_service.agenda.create.CreateAgendaService;
import com.assembly.assembly_service.agenda.create.models.AgendaRequest;
import com.assembly.assembly_service.agenda.create.models.AgendaResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgendaControllerTest {

    @Mock
    private CreateAgendaService createAgendaService;

    @InjectMocks
    private AgendaController agendaController;

    @Test
    void testCreateAgendaSuccess() {
        var agendaRequest = Mockito.mock(AgendaRequest.class);
        var agendaResponse = Mockito.mock(AgendaResponse.class);

        when(createAgendaService.createAgenda(agendaRequest)).thenReturn(agendaResponse);

        ResponseEntity<AgendaResponse> result = agendaController.create(agendaRequest);

        assertNotNull(result);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(agendaResponse, result.getBody());
        verify(createAgendaService, times(1)).createAgenda(any());
    }
}