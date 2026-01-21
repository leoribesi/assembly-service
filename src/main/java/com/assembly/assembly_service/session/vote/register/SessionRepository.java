package com.assembly.assembly_service.session.vote.register;

import com.assembly.assembly_service.shared.entities.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<SessionEntity, Long> {

    @Query(value = """
    SELECT s FROM SessionEntity s
    WHERE s.id = :sessionId
    AND s.endTime >= :now
    """)
    Optional<SessionEntity> findSessionOpened(Long sessionId, LocalDateTime now);
}
