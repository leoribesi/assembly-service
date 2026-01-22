package com.assembly.assembly_service.agenda.create;

import com.assembly.assembly_service.agenda.create.models.AgendaRequest;
import com.assembly.assembly_service.agenda.create.models.AgendaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateAgendaService {

    private final CreateAgendaRepository createAgendaRepository;

    public AgendaResponse createAgenda(AgendaRequest agendaRequest) {
        log.info("Creating agenda with title: {}", agendaRequest.title());
        var agendaEntity = createAgendaRepository.save(agendaRequest.toEntity());

        log.info("Created agenda with title: {}", agendaEntity.getId());
        return agendaEntity.toResponse();
    }
}
