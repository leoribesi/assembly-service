package com.assembly.assembly_service.associate.create.models;

import lombok.Builder;

@Builder
public record AssociateResponse(
        Long id,
        String name
) {
}
