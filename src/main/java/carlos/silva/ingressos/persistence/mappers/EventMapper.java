package carlos.silva.ingressos.persistence.mappers;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import carlos.silva.ingressos.domain.models.event.Event;
import carlos.silva.ingressos.domain.models.event.EventId;
import carlos.silva.ingressos.domain.models.value_objects.EventName;
import carlos.silva.ingressos.domain.models.value_objects.DateTimePeriod;
import carlos.silva.ingressos.persistence.entities.EventEntity;
import jakarta.validation.constraints.NotNull;

@Component
@Validated
public class EventMapper {

    public EventEntity fromDomain(@NotNull Event event) {
        return new EventEntity(
                event.getId().value(),
                event.getName().value(),
                event.getDescription(),
                event.getPeriod().start(),
                event.getPeriod().end(),
                event.getMinimalAge());
    }

    public Event toDomain(@NotNull EventEntity eventEntity) {
        return new Event(
                new EventId(eventEntity.getId()),
                new EventName(eventEntity.getName()),
                eventEntity.getDescription(),
                new DateTimePeriod(eventEntity.getStart(), eventEntity.getEnd()),
                eventEntity.getMinimalAge());
    }
}