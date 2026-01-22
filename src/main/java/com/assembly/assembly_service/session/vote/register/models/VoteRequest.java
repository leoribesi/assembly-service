package com.assembly.assembly_service.session.vote.register.models;

import com.assembly.assembly_service.shared.entities.AssociateEntity;
import com.assembly.assembly_service.shared.entities.SessionEntity;
import com.assembly.assembly_service.shared.entities.VoteEntity;
import com.assembly.assembly_service.shared.enums.VoteEnum;
import jakarta.validation.constraints.NotNull;

public record VoteRequest(
        @NotNull(message = "O voto não pode ser nulo")
        VoteEnum vote,
        @NotNull(message = "O ID do associado não pode ser nulo")
        Long associateId
) {
    public VoteEntity toEntity(Long sessionId) {
        return VoteEntity.builder()
                .vote(vote)
                .associate(AssociateEntity.builder().id(associateId).build())
                .session(SessionEntity.builder().id(sessionId).build())
                .build();
    }
}
