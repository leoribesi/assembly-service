package com.assembly.assembly_service.session.vote.result;

import com.assembly.assembly_service.shared.entities.SessionEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultSessionRepository extends JpaRepository<SessionEntity, Long> {

    @EntityGraph(attributePaths = {"agenda"})
    @Query(value = """
    SELECT s.agenda.title FROM SessionEntity s
    WHERE s.id = :sessionId
    AND s.agenda.id = :agendaId
    """)
    String findAgendaTitle(Long sessionId, Long agendaId);
}
