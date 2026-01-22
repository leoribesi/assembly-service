package com.assembly.assembly_service.shared.entities;

import com.assembly.assembly_service.agenda.create.models.AgendaResponse;
import com.assembly.assembly_service.session.create.models.SessionResponse;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name = "session")
public class SessionEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private AgendaEntity agenda;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session", orphanRemoval = true)
    private List<VoteEntity> votes;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public SessionResponse toResponse() {
        return SessionResponse.builder()
                .id(this.getId())
                .agenda(AgendaResponse.builder().id(agenda.getId()).build())
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
