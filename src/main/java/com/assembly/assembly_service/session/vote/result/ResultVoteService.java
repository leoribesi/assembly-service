package com.assembly.assembly_service.session.vote.result;

import com.assembly.assembly_service.session.vote.result.models.VoteResults;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResultVoteService {

    private final ResultSessionVoteRepository resultSessionVoteRepository;
    private final ResultSessionRepository resultSessionRepository;

    public VoteResults result(Long sessionId, Long agendaId) {
        log.info("Loading result for agenda ID: {}", agendaId);
        String agendaTitle = resultSessionRepository.findAgendaTitle(sessionId, agendaId);
        Integer votesYes = resultSessionVoteRepository.countAllVotesYes(sessionId, agendaId);
        Integer votesNo = resultSessionVoteRepository.countAllVotesNo(sessionId, agendaId);

        log.info("Vote result loaded with success for agenda ID: {}", agendaId);
        return new VoteResults(agendaTitle, votesYes, votesNo);
    }
}
