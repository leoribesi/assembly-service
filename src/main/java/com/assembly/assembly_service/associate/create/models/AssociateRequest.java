package com.assembly.assembly_service.associate.create.models;

import com.assembly.assembly_service.shared.entities.AssociateEntity;

public record AssociateRequest(
        String name
) {
    public AssociateEntity toEntity() {
        return AssociateEntity.builder()
                .name(name)
                .build();
    }
}
