package com.assembly.assembly_service.session.vote.result;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResultVoteServiceTest {

    @Mock
    private ResultSessionVoteRepository resultSessionVoteRepository;

    @Mock
    private ResultSessionRepository resultSessionRepository;

    @InjectMocks
    private ResultVoteService resultVoteService;

    @Test
    void testResultVoteSuccess() {
        var sessionId = 1L;
        var agendaId = 1L;
        var agendaTitle = "Pauta de Votação";
        var votesYes = 10;
        var votesNo = 5;

        when(resultSessionRepository.findAgendaTitle(sessionId, agendaId))
            .thenReturn(agendaTitle);
        when(resultSessionVoteRepository.countAllVotesYes(sessionId, agendaId))
            .thenReturn(votesYes);
        when(resultSessionVoteRepository.countAllVotesNo(sessionId, agendaId))
            .thenReturn(votesNo);

        var result = resultVoteService.result(sessionId, agendaId);

        assertNotNull(result);
        assertEquals(agendaTitle, result.agenda());
        assertEquals(votesYes, result.yes());
        assertEquals(votesNo, result.no());

        verify(resultSessionRepository, times(1)).findAgendaTitle(anyLong(), anyLong());
        verify(resultSessionVoteRepository, times(1)).countAllVotesYes(anyLong(), anyLong());
        verify(resultSessionVoteRepository, times(1)).countAllVotesNo(anyLong(), anyLong());
    }
}
