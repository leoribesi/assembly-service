package com.assembly.assembly_service.agenda.create;

import com.assembly.assembly_service.agenda.create.models.AgendaRequest;
import com.assembly.assembly_service.agenda.create.models.AgendaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAgendaService {

    private final CreateAgendaRepository createAgendaRepository;

    public AgendaResponse createAgenda(AgendaRequest agendaRequest) {
        var agendaEntity = createAgendaRepository.save(agendaRequest.toEntity());

        return agendaEntity.toResponse();
    }
}
