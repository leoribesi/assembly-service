package com.assembly.assembly_service.associate.create;

import com.assembly.assembly_service.associate.create.models.AssociateRequest;
import com.assembly.assembly_service.associate.create.models.AssociateResponse;
import com.assembly.assembly_service.shared.entities.AssociateEntity;
import com.assembly.assembly_service.shared.exceptions.AlreadyExistsAssociateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateAssociateService {

    private final CreateAssociateRepository createAssociateRepository;

    public AssociateResponse create(AssociateRequest associateRequest) {
        log.info("Creating Associate");
        AssociateEntity associateEntity;

        try {
            associateEntity = createAssociateRepository.save(associateRequest.toEntity());
        } catch (DataIntegrityViolationException ex) {
            log.error("Associate with CPF already exists");
            throw new AlreadyExistsAssociateException("Associate with CPF already exists");
        }

        log.info("Associate created with ID: {}", associateEntity.getId());
        return associateEntity.toResponse();
    }
}
