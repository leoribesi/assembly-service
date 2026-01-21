package com.assembly.assembly_service.session.vote.result;

import com.assembly.assembly_service.session.vote.result.models.VoteResults;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultVoteService {

    private final ResultSessionVoteRepository resultSessionVoteRepository;
    private final ResultSessionRepository resultSessionRepository;

    public VoteResults result(Long sessionId, Long agendaId) {
        String agendaTitle = resultSessionRepository.findAgendaTitle(sessionId, agendaId);
        Integer votesYes = resultSessionVoteRepository.countAllVotesYes(sessionId, agendaId);
        Integer votesNo = resultSessionVoteRepository.countAllVotesNo(sessionId, agendaId);

        return new VoteResults(agendaTitle, votesYes, votesNo);
    }
}
