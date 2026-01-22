package com.assembly.assembly_service.session;

import com.assembly.assembly_service.session.create.CreateSessionService;
import com.assembly.assembly_service.session.create.models.SessionRequest;
import com.assembly.assembly_service.session.create.models.SessionResponse;
import com.assembly.assembly_service.session.vote.register.RegisterVoteService;
import com.assembly.assembly_service.session.vote.register.models.VoteRequest;
import com.assembly.assembly_service.session.vote.result.ResultVoteService;
import com.assembly.assembly_service.session.vote.result.models.VoteResults;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/sessions")
public class SessionController {

    private final CreateSessionService createSessionService;
    private final RegisterVoteService registerVoteService;
    private final ResultVoteService resultVoteService;

    @Operation(summary = "Cria uma nova Sessão de Votação")
    @PostMapping()
    public ResponseEntity<SessionResponse> create(@RequestBody @Valid SessionRequest sessionRequest) {
        var sessionResponse = createSessionService.create(sessionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(sessionResponse);
    }

    @Operation(summary = "Registra um voto em uma Sessão de Votação")
    @PostMapping("/{id}/votes")
    public ResponseEntity<Void> register(@PathVariable Long id, @RequestBody @Valid  VoteRequest voteRequest) {
        registerVoteService.register(id, voteRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @Operation(summary = "Obtém o resultado da votação de uma Pauta em uma Sessão de Votação")
    @GetMapping("/{id}/agendas/{agendaId}/votes/results")
    public ResponseEntity<VoteResults> result(@PathVariable Long id, @PathVariable Long agendaId) {
        var result = resultVoteService.result(id, agendaId);
        return ResponseEntity.ok(result);
    }
}
