package com.assembly.assembly_service.associate.create;

import com.assembly.assembly_service.associate.create.models.AssociateRequest;
import com.assembly.assembly_service.associate.create.models.AssociateResponse;
import com.assembly.assembly_service.shared.entities.AssociateEntity;
import com.assembly.assembly_service.shared.exceptions.AlreadyExistsAssociateException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateAssociateServiceTest {

    @Mock
    private CreateAssociateRepository createAssociateRepository;

    @InjectMocks
    private CreateAssociateService createAssociateService;

    @Test
    void testCreateAssociateSuccess() {
        var associateRequest = Mockito.mock(AssociateRequest.class);
        var associateEntity = Mockito.mock(AssociateEntity.class);
        var associateResponse = Mockito.mock(AssociateResponse.class);

        when(createAssociateRepository.save(associateEntity)).thenReturn(associateEntity);
        when(associateEntity.toResponse()).thenReturn(associateResponse);
        when(associateRequest.toEntity()).thenReturn(associateEntity);

        var result = createAssociateService.create(associateRequest);

        assertNotNull(result);
        assertEquals(associateResponse, result);
        verify(createAssociateRepository, times(1)).save(any());
    }

    @Test
    void testCreateAssociateWithDuplicateCpf() {
        var associateRequest = Mockito.mock(AssociateRequest.class);

        when(createAssociateRepository.save(any()))
                .thenThrow(new DataIntegrityViolationException("CPF already exists"));

        assertThrows(AlreadyExistsAssociateException.class,
                () -> createAssociateService.create(associateRequest));
    }
}