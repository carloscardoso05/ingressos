package carlos.silva.ingressos.domain.event;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.domain.AbstractAggregateRoot;

import carlos.silva.ingressos.domain.DomainException;
import carlos.silva.ingressos.domain.user.User;
import carlos.silva.ingressos.domain.value_objects.EventName;
import carlos.silva.ingressos.domain.value_objects.EventPeriod;
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
    private EventPeriod period;
    @Getter
    private Integer minimalAge;

    public Event(EventId id, EventName name, String description, EventPeriod period, Integer minimalAge) {
        if (minimalAge == null || minimalAge >= 0) {
            throw new DomainException("Minimal age must be positive or null");
        }

        this.id = checkNotNull(id);
        this.name = checkNotNull(name);
        this.description = Objects.requireNonNullElse(description, "");
        this.period = checkNotNull(period);
        this.minimalAge = minimalAge;
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
