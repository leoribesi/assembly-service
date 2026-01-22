package com.assembly.assembly_service.shared.entities;

import com.assembly.assembly_service.associate.create.models.AssociateResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name = "associate")
public class AssociateEntity extends AbstractEntity {

    private String name;

    @Column(unique = true)
    private String cpf;

    public AssociateResponse toResponse() {
        return AssociateResponse.builder()
                .id(this.getId())
                .name(name)
                .cpf(cpf)
                .build();
    }
}
