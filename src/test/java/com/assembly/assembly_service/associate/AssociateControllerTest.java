package com.assembly.assembly_service.associate;

import com.assembly.assembly_service.associate.create.CreateAssociateService;
import com.assembly.assembly_service.associate.create.models.AssociateRequest;
import com.assembly.assembly_service.associate.create.models.AssociateResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssociateControllerTest {

    @Mock
    private CreateAssociateService createAssociateService;

    @InjectMocks
    private AssociateController associateController;

    @Test
    void testCreateAssociateSuccess() {
        var associateRequest = Mockito.mock(AssociateRequest.class);
        var associateResponse = Mockito.mock(AssociateResponse.class);

        when(createAssociateService.create(associateRequest)).thenReturn(associateResponse);

        ResponseEntity<AssociateResponse> result = associateController.create(associateRequest);

        assertNotNull(result);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(associateResponse, result.getBody());
        verify(createAssociateService, times(1)).create(any());
    }
}