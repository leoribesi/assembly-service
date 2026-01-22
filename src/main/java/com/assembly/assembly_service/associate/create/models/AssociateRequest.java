package com.assembly.assembly_service.associate.create.models;

import com.assembly.assembly_service.shared.entities.AssociateEntity;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record AssociateRequest(
        @NotBlank(message = "O nome do associado é obrigatório")
        String name,
        @CPF(message = "O CPF informado é inválido")
        @NotBlank(message = "O CPF do associado é obrigatório")
        String cpf
) {
    public AssociateEntity toEntity() {
        return AssociateEntity.builder()
                .name(name)
                .cpf(cpf)
                .build();
    }
}
