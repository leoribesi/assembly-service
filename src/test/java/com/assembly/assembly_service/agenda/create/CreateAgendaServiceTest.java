package com.assembly.assembly_service.agenda.create;

import com.assembly.assembly_service.agenda.create.models.AgendaRequest;
import com.assembly.assembly_service.agenda.create.models.AgendaResponse;
import com.assembly.assembly_service.shared.entities.AgendaEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateAgendaServiceTest {

    @Mock
    private CreateAgendaRepository createAgendaRepository;

    @InjectMocks
    private CreateAgendaService createAgendaService;

    @Test
    void testCreateAgendaSuccess() {
        var agendaRequest = Mockito.mock(AgendaRequest.class);
        var agendaEntity = Mockito.mock(AgendaEntity.class);
        var agendaResponse = Mockito.mock(AgendaResponse.class);

        when(createAgendaRepository.save(agendaEntity)).thenReturn(agendaEntity);
        when(agendaEntity.toResponse()).thenReturn(agendaResponse);
        when(agendaRequest.toEntity()).thenReturn(agendaEntity);

        var result = createAgendaService.createAgenda(agendaRequest);

        assertNotNull(result);
        assertEquals(agendaResponse, result);
        verify(createAgendaRepository, times(1)).save(any());
    }
}
