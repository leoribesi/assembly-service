package com.assembly.assembly_service.session.vote.register.models;

import com.assembly.assembly_service.shared.entities.AssociateEntity;
import com.assembly.assembly_service.shared.entities.SessionEntity;
import com.assembly.assembly_service.shared.entities.VoteEntity;
import com.assembly.assembly_service.shared.enums.VoteEnum;

public record VoteRequest(
        VoteEnum vote,
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
