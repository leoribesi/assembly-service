package com.assembly.assembly_service.session.create;

import com.assembly.assembly_service.session.create.models.SessionRequest;
import com.assembly.assembly_service.session.create.models.SessionResponse;
import com.assembly.assembly_service.shared.entities.SessionEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateSessionService {

    private final CreateSessionRepository createSessionRepository;

    public SessionResponse create(SessionRequest sessionRequest) {
        log.info("Creating session for agenda ID: {}", sessionRequest.agendaId());
        SessionEntity sessionEntity = sessionRequest.toEntity();
        createSessionTimer(sessionEntity);

        sessionEntity = createSessionRepository.save(sessionEntity);

        log.info("Created session for agenda ID: {}", sessionEntity.getId());
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
