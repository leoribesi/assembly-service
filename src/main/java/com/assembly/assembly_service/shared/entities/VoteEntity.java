package com.assembly.assembly_service.shared.entities;

import com.assembly.assembly_service.shared.enums.VoteEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "vote")
public class VoteEntity extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private VoteEnum vote;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private SessionEntity session;

    @ManyToOne
    @JoinColumn(name = "associate_id")
    private AssociateEntity associate;
}
