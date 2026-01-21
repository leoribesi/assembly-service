package com.assembly.assembly_service.session.vote.result;

import com.assembly.assembly_service.shared.entities.VoteEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultSessionVoteRepository extends JpaRepository<VoteEntity, Long> {

    @EntityGraph(attributePaths = {"session", "session.agenda"})
    @Query(value = """
    SELECT COUNT(v) FROM VoteEntity v
    WHERE v.session.id = :sessionId
    AND v.session.agenda.id = :agendaId
    AND v.vote = 'YES'
    """)
    Integer countAllVotesYes(Long sessionId, Long agendaId);

    @EntityGraph(attributePaths = {"session", "session.agenda"})
    @Query(value = """
    SELECT COUNT(v) FROM VoteEntity v
    WHERE v.session.id = :sessionId
    AND v.session.agenda.id = :agendaId
    AND v.vote = 'NO'
    """)
    Integer countAllVotesNo(Long sessionId, Long agendaId);
}
