package com.assembly.assembly_service.session.create.models;

import com.assembly.assembly_service.shared.entities.AgendaEntity;
import com.assembly.assembly_service.shared.entities.SessionEntity;

import java.time.LocalDateTime;

public record SessionRequest(
        Long agendaId,
        Long associateId,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
    public SessionEntity toEntity() {
        return SessionEntity.builder()
                .agenda(AgendaEntity.builder().id(agendaId).build())
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
