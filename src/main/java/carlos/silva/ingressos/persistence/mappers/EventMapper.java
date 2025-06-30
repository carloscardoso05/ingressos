package carlos.silva.ingressos.persistence.mappers;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import carlos.silva.ingressos.domain.models.event.Event;
import carlos.silva.ingressos.domain.models.event.EventId;
import carlos.silva.ingressos.domain.models.event.Session;
import carlos.silva.ingressos.domain.models.event.SessionId;
import carlos.silva.ingressos.domain.models.value_objects.DateTimePeriod;
import carlos.silva.ingressos.domain.models.value_objects.EventName;
import carlos.silva.ingressos.persistence.entities.EventEntity;
import carlos.silva.ingressos.persistence.entities.SessionEntity;
import carlos.silva.ingressos.persistence.repositories.EventEntityRepository;
import carlos.silva.ingressos.persistence.repositories.SessionEntityRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Component
@Validated
@RequiredArgsConstructor
public class EventMapper {
    private final EventEntityRepository eventEntityRepository;
    private final SessionEntityRepository sessionEntityRepository;

    public EventEntity fromDomain(@NotNull Event event) {
        return new EventEntity(
                event.getId().value(),
                event.getName().value(),
                event.getDescription(),
                event.getPeriod().start(),
                event.getPeriod().end(),
                event.getMinimalAge(),
                event.getSessions().stream().map(this::sesstionToEntity).toList());
    }

    public Event toDomain(@NotNull EventEntity eventEntity) {
        return new Event(
                new EventId(eventEntity.getId()),
                new EventName(eventEntity.getName()),
                eventEntity.getDescription(),
                new DateTimePeriod(eventEntity.getStart(), eventEntity.getEnd()),
                eventEntity.getMinimalAge(),
                sessionEntityRepository.findAllByEventId(eventEntity.getId()).stream().map(this::sessionToDomain)
                        .toList());
    }

    public Session sessionToDomain(SessionEntity entity) {
        return new Session(
                new SessionId(entity.getId()),
                new EventId(entity.getId()),
                entity.getName(),
                new DateTimePeriod(entity.getStart(), entity.getEnd()));
    }

    public SessionEntity sesstionToEntity(Session domain) {
        return new SessionEntity(
                domain.getId().value(),
                domain.getName(),
                eventEntityRepository.findById(domain.getEventId().value()).orElseThrow(),
                domain.getPeriod().start(),
                domain.getPeriod().end());
    }
}