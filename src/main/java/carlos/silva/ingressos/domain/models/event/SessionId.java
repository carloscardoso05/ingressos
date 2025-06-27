package carlos.silva.ingressos.domain.models.event;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.UUID;

public record SessionId(UUID value) {
    public SessionId() {
        this(UUID.randomUUID());
    }

    public SessionId {
        checkNotNull(value);
    }
}
