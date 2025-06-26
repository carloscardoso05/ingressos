package carlos.silva.ingressos.domain.event;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.UUID;

public record EventId(UUID value) {
    public EventId() {
        this(UUID.randomUUID());
    }

    public EventId {
        checkNotNull(value, "EventId value must not be null");
    }
}
