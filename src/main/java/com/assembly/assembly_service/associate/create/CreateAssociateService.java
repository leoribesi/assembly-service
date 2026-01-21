package com.assembly.assembly_service.associate.create;

import com.assembly.assembly_service.associate.create.models.AssociateRequest;
import com.assembly.assembly_service.associate.create.models.AssociateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAssociateService {

    private final CreateAssociateRepository createAssociateRepository;

    public AssociateResponse create(AssociateRequest associateRequest) {
        var associateEntity = createAssociateRepository.save(associateRequest.toEntity());

        return associateEntity.toResponse();
    }
}
