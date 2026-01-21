package com.assembly.assembly_service.session.create;

import com.assembly.assembly_service.session.create.models.SessionRequest;
import com.assembly.assembly_service.session.create.models.SessionResponse;
import com.assembly.assembly_service.shared.entities.SessionEntity;
import com.assembly.assembly_service.shared.enums.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateSessionService {

    private final CreateSessionRepository createSessionRepository;

    public SessionResponse create(SessionRequest sessionRequest) {
        SessionEntity sessionEntity = sessionRequest.toEntity();
        createSessionTimer(sessionEntity);

        sessionEntity.setStatus(StatusEnum.OPENED);

        sessionEntity = createSessionRepository.save(sessionEntity);

        return sessionEntity.toResponse();
    }

    private void createSessionTimer(SessionEntity sessionEntity) {
        if (sessionEntity.getStartTime() == null) {
            var startTime = LocalDateTime.now();
            var endTime = startTime.plusMinutes(1);

            sessionEntity.setStartTime(startTime);
            sessionEntity.setEndTime(endTime);
        }
    }
}
