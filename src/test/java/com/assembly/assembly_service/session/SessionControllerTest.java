package com.assembly.assembly_service.session;

import com.assembly.assembly_service.session.create.CreateSessionService;
import com.assembly.assembly_service.session.create.models.SessionRequest;
import com.assembly.assembly_service.session.create.models.SessionResponse;
import com.assembly.assembly_service.session.vote.register.RegisterVoteService;
import com.assembly.assembly_service.session.vote.register.models.VoteRequest;
import com.assembly.assembly_service.session.vote.result.ResultVoteService;
import com.assembly.assembly_service.session.vote.result.models.VoteResults;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SessionControllerTest {

    @Mock
    private CreateSessionService createSessionService;

    @Mock
    private RegisterVoteService registerVoteService;

    @Mock
    private ResultVoteService resultVoteService;

    @InjectMocks
    private SessionController sessionController;

    @Test
    void testCreateSessionSuccess() {
        var sessionRequest = Mockito.mock(SessionRequest.class);
        var sessionResponse = Mockito.mock(SessionResponse.class);

        when(createSessionService.create(sessionRequest)).thenReturn(sessionResponse);

        ResponseEntity<SessionResponse> result = sessionController.create(sessionRequest);

        assertNotNull(result);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(sessionResponse, result.getBody());
        verify(createSessionService, times(1)).create(any());
    }

    @Test
    void testRegisterVoteSuccess() {
        var voteRequest = Mockito.mock(VoteRequest.class);
        var sessionId = 1L;

        ResponseEntity<Void> result = sessionController.register(sessionId, voteRequest);

        assertNotNull(result);
        assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());
        verify(registerVoteService, times(1)).register(anyLong(), any());
    }

    @Test
    void testResultVoteSuccess() {
        var voteResults = Mockito.mock(VoteResults.class);
        var sessionId = 1L;
        var agendaId = 1L;

        when(resultVoteService.result(sessionId, agendaId)).thenReturn(voteResults);

        ResponseEntity<VoteResults> result = sessionController.result(sessionId, agendaId);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(voteResults, result.getBody());
        verify(resultVoteService, times(1)).result(anyLong(), anyLong());
    }
}