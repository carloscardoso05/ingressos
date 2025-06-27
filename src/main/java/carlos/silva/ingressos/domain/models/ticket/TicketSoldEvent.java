package carlos.silva.ingressos.domain.models.ticket;

import java.time.Instant;

public record TicketSoldEvent(Ticket ticket, Instant selledAt) {
}
