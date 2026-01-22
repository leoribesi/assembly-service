package com.assembly.assembly_service.session.vote.register;

import com.assembly.assembly_service.session.vote.register.models.VoteRequest;
import com.assembly.assembly_service.shared.entities.SessionEntity;
import com.assembly.assembly_service.shared.entities.VoteEntity;
import com.assembly.assembly_service.shared.exceptions.AlreadyExistsVoteException;
import com.assembly.assembly_service.shared.exceptions.SessionClosedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterVoteServiceTest {

    @Mock
    private RegisterVoteRepository registerVoteRepository;

    @Mock
    private SessionRepository sessionRepository;

    @InjectMocks
    private RegisterVoteService registerVoteService;

    @Test
    void testRegisterVoteSuccess() {
        var voteRequest = Mockito.mock(VoteRequest.class);
        var voteEntity = Mockito.mock(VoteEntity.class);
        var sessionEntity = Mockito.mock(SessionEntity.class);
        var sessionId = 1L;

        when(sessionRepository.findSessionOpened(anyLong(), any(LocalDateTime.class)))
            .thenReturn(Optional.of(sessionEntity));
        when(registerVoteRepository.findVote(sessionId, voteRequest.associateId()))
            .thenReturn(Optional.empty());
        when(voteRequest.toEntity(sessionId)).thenReturn(voteEntity);

        registerVoteService.register(sessionId, voteRequest);

        verify(sessionRepository, times(1)).findSessionOpened(anyLong(), any(LocalDateTime.class));
        verify(registerVoteRepository, times(1)).findVote(anyLong(), any());
        verify(registerVoteRepository, times(1)).save(any());
    }

    @Test
    void testRegisterVoteSessionClosed() {
        var voteRequest = Mockito.mock(VoteRequest.class);
        var sessionId = 1L;

        when(sessionRepository.findSessionOpened(anyLong(), any(LocalDateTime.class)))
            .thenReturn(Optional.empty());

        assertThrows(SessionClosedException.class,
            () -> registerVoteService.register(sessionId, voteRequest));
    }

    @Test
    void testRegisterVoteAlreadyExists() {
        var voteRequest = Mockito.mock(VoteRequest.class);
        var voteEntity = Mockito.mock(VoteEntity.class);
        var sessionEntity = Mockito.mock(SessionEntity.class);
        var sessionId = 1L;

        when(sessionRepository.findSessionOpened(anyLong(), any(LocalDateTime.class)))
            .thenReturn(Optional.of(sessionEntity));
        when(registerVoteRepository.findVote(sessionId, voteRequest.associateId()))
            .thenReturn(Optional.of(voteEntity));

        assertThrows(AlreadyExistsVoteException.class,
            () -> registerVoteService.register(sessionId, voteRequest));
    }
}