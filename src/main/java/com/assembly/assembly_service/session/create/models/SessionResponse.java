package com.assembly.assembly_service.session.create.models;

import com.assembly.assembly_service.agenda.create.models.AgendaResponse;
import com.assembly.assembly_service.shared.enums.VoteEnum;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SessionResponse(
        Long id,
        AgendaResponse agenda,
        VoteEnum vote,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
