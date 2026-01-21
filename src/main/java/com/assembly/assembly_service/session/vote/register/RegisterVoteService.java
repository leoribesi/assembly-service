package com.assembly.assembly_service.session.vote.register;

import com.assembly.assembly_service.session.vote.register.models.VoteRequest;
import com.assembly.assembly_service.shared.exceptions.AlreadyExistsVoteException;
import com.assembly.assembly_service.shared.exceptions.SessionClosedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegisterVoteService {

    private final RegisterVoteRepository registerVoteRepository;
    private final SessionRepository sessionRepository;

    public void register(Long sessionId, VoteRequest voteRequest) {
        var now = LocalDateTime.now();

        sessionRepository.findSessionOpened(sessionId, now)
                .orElseThrow(() -> new SessionClosedException("Session is closed for voting"));

        registerVoteRepository.findVote(sessionId, voteRequest.associateId())
                .ifPresent(throwable -> {
                    throw new AlreadyExistsVoteException("Associate has already voted in this session");
                });

        registerVoteRepository.save(voteRequest.toEntity(sessionId));
    }
}
