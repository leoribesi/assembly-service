package com.assembly.assembly_service.session.create;

import com.assembly.assembly_service.session.create.models.SessionRequest;
import com.assembly.assembly_service.session.create.models.SessionResponse;
import com.assembly.assembly_service.shared.entities.SessionEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateSessionServiceTest {

    @Mock
    private CreateSessionRepository createSessionRepository;

    @InjectMocks
    private CreateSessionService createSessionService;

    @Test
    void testCreateSessionSuccessWithStartTimeNull() {
        var sessionRequest = Mockito.mock(SessionRequest.class);
        var sessionEntity = Mockito.mock(SessionEntity.class);
        var sessionResponse = Mockito.mock(SessionResponse.class);

        when(sessionRequest.toEntity()).thenReturn(sessionEntity);
        when(sessionEntity.getStartTime()).thenReturn(null);
        when(createSessionRepository.save(sessionEntity)).thenReturn(sessionEntity);
        when(sessionEntity.toResponse()).thenReturn(sessionResponse);

        var result = createSessionService.create(sessionRequest);

        assertNotNull(result);
        assertEquals(sessionResponse, result);
        verify(createSessionRepository, times(1)).save(any());
        verify(sessionEntity, times(1)).setStartTime(any());
        verify(sessionEntity, times(1)).setEndTime(any());
    }

    @Test
    void testCreateSessionSuccessWithStartTimeNotNull() {
        var sessionRequest = Mockito.mock(SessionRequest.class);
        var sessionEntity = Mockito.mock(SessionEntity.class);
        var sessionResponse = Mockito.mock(SessionResponse.class);
        var startTime = LocalDateTime.now();

        when(sessionRequest.toEntity()).thenReturn(sessionEntity);
        when(sessionEntity.getStartTime()).thenReturn(startTime);
        when(createSessionRepository.save(sessionEntity)).thenReturn(sessionEntity);
        when(sessionEntity.toResponse()).thenReturn(sessionResponse);

        var result = createSessionService.create(sessionRequest);

        assertNotNull(result);
        assertEquals(sessionResponse, result);
        verify(createSessionRepository, times(1)).save(any());
        verify(sessionEntity, times(0)).setStartTime(any());
        verify(sessionEntity, times(0)).setEndTime(any());

    }
}