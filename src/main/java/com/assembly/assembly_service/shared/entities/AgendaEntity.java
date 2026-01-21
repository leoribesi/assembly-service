package com.assembly.assembly_service.shared.entities;

import com.assembly.assembly_service.agenda.create.models.AgendaResponse;
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
@Table(name = "agenda")
public class AgendaEntity extends AbstractEntity {

    private String title;
    private String description;

    public AgendaResponse toResponse() {
        return AgendaResponse.builder()
                .id(this.getId())
                .title(this.title)
                .description(this.description)
                .build();
    }
}
