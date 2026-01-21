package com.assembly.assembly_service.agenda.create.models;

import com.assembly.assembly_service.shared.entities.AgendaEntity;
import lombok.Builder;

@Builder
public record AgendaResponse(
        Long id,
        String title,
        String description
) {
    public AgendaEntity toEntity() {
        return AgendaEntity.builder()
                .title(title)
                .description(description)
                .build();
    }
}
