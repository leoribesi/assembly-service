package com.assembly.assembly_service.session.create;

import com.assembly.assembly_service.shared.entities.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateSessionRepository extends JpaRepository<SessionEntity, Long> {
}
