package com.assembly.assembly_service.agenda;

import com.assembly.assembly_service.agenda.create.CreateAgendaService;
import com.assembly.assembly_service.agenda.create.models.AgendaRequest;
import com.assembly.assembly_service.agenda.create.models.AgendaResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/agendas")
public class AgendaController {

    private final CreateAgendaService createAgendaService;

    @Operation(summary = "Cria uma nova Pauta")
    @PostMapping()
    public ResponseEntity<AgendaResponse> create(@RequestBody AgendaRequest request) {
        var agendaResponse = createAgendaService.createAgenda(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaResponse);
    }
}
