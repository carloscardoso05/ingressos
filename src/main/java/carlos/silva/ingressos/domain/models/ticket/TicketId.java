package carlos.silva.ingressos.domain.models.ticket;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.UUID;

public record TicketId(UUID value) {
    public TicketId() {
        this(UUID.randomUUID());
    }

    public TicketId {
        checkNotNull(value, "TicketId value must not be null");
    }
}
