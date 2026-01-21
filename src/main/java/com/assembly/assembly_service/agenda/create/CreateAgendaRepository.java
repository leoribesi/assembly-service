package com.assembly.assembly_service.agenda.create;

import com.assembly.assembly_service.shared.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateAgendaRepository extends JpaRepository<AgendaEntity, Long> {
}
