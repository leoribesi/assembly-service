package com.assembly.assembly_service.associate;

import com.assembly.assembly_service.associate.create.CreateAssociateService;
import com.assembly.assembly_service.associate.create.models.AssociateRequest;
import com.assembly.assembly_service.associate.create.models.AssociateResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/associates")
public class AssociateController {

    private final CreateAssociateService createAssociateService;

    @Operation(summary = "Cria um novo Associado")
    @PostMapping()
    public ResponseEntity<AssociateResponse> create(@RequestBody @Valid AssociateRequest associateRequest) {
        var associateResponse = createAssociateService.create(associateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(associateResponse);
    }
}
