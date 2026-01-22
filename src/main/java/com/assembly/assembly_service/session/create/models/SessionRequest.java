package com.assembly.assembly_service.session.create.models;

import com.assembly.assembly_service.shared.entities.AgendaEntity;
import com.assembly.assembly_service.shared.entities.SessionEntity;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record SessionRequest(
        @NotNull(message = "O ID da pauta é obrigatório")
        Long agendaId,
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
