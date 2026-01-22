package com.assembly.assembly_service.session.vote.register;

import com.assembly.assembly_service.session.vote.register.models.VoteRequest;
import com.assembly.assembly_service.shared.exceptions.AlreadyExistsVoteException;
import com.assembly.assembly_service.shared.exceptions.SessionClosedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterVoteService {

    private final RegisterVoteRepository registerVoteRepository;
    private final SessionRepository sessionRepository;

    public void register(Long sessionId, VoteRequest voteRequest) {
        log.info("Registering vote");
        var now = LocalDateTime.now();

        sessionRepository.findSessionOpened(sessionId, now)
                .orElseThrow(() -> {
                    log.error("Session is closed for voting");
                    return new SessionClosedException("Session is closed for voting");
                });

        registerVoteRepository.findVote(sessionId, voteRequest.associateId())
                .ifPresent(throwable -> {
                    log.error("Associate has already voted in this session");
                    throw new AlreadyExistsVoteException("Associate has already voted in this session");
                });

        log.info("Vote has been registered");
        registerVoteRepository.save(voteRequest.toEntity(sessionId));
    }
}
