package carlos.silva.ingressos.domain.event;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDateTime;

import carlos.silva.ingressos.domain.user.User;
import carlos.silva.ingressos.domain.value_objects.EventName;
import lombok.Getter;

public class Event {
    @Getter
    private final EventId id;
    @Getter
    private EventName name;
    @Getter
    private String description;
    @Getter
    private LocalDateTime starDateTime;
    @Getter
    private LocalDateTime endDateTime;
    @Getter
    private Integer minimalAge;

    public Event(EventId id, EventName name, String description, LocalDateTime starDateTime,
            LocalDateTime endDateTime, Integer minimalAge) {
        checkArgument(minimalAge == null || minimalAge >= 0, "Minimal age must be positive or null");

        this.id = checkNotNull(id);
        this.name = checkNotNull(name);
        this.description = checkNotNull(description);
        this.starDateTime = checkNotNull(starDateTime);
        this.endDateTime = checkNotNull(endDateTime);
        this.minimalAge = minimalAge;
    }

    public void changeName(EventName newName) {
        name = checkNotNull(newName, "New Name must not be null");
    }

    public boolean isHappening() {
        return LocalDateTime.now().isAfter(starDateTime);
    }

    public boolean hasEnded() {
        return LocalDateTime.now().isAfter(endDateTime);
    }

    public boolean areMinorsAllowed() {
        return minimalAge == null || minimalAge < User.LEGAL_AGE;
    }

}
