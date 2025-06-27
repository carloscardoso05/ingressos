package carlos.silva.ingressos.domain.models.event;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.AbstractAggregateRoot;

import carlos.silva.ingressos.domain.DomainException;
import carlos.silva.ingressos.domain.models.user.User;
import carlos.silva.ingressos.domain.models.value_objects.DateTimePeriod;
import carlos.silva.ingressos.domain.models.value_objects.EventName;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = "id", callSuper = false)
public class Event extends AbstractAggregateRoot<Event> {
    @Getter
    private final EventId id;
    @Getter
    private EventName name;
    @Getter
    private String description;
    @Getter
    private DateTimePeriod period;
    @Getter
    private Integer minimalAge;
    @Getter
    private final List<Session> sessions = new ArrayList<>();

    public Event(EventId id, EventName name, String description, DateTimePeriod period, Integer minimalAge,
            Collection<Session> sessions) {
        if (minimalAge != null && minimalAge < 0) {
            throw new DomainException("Minimal age must be positive or null");
        }

        this.id = checkNotNull(id);
        this.name = checkNotNull(name);
        this.description = Objects.requireNonNullElse(description, "");
        this.period = checkNotNull(period);
        this.minimalAge = minimalAge;
        checkArgument(sessions.stream().allMatch(session -> session.getEventId().equals(id)));
        this.sessions.addAll(sessions);
    }

    public void changeName(EventName newName) {
        name = checkNotNull(newName, "New Name must not be null");
    }

    public boolean isHappening() {
        return LocalDateTime.now().isAfter(period.start());
    }

    public boolean hasEnded() {
        return LocalDateTime.now().isAfter(period.end());
    }

    public boolean areMinorsAllowed() {
        return minimalAge == null || minimalAge < User.LEGAL_AGE;
    }

}
