package carlos.silva.ingressos.domain.ticket;

import java.time.Instant;

public record TicketSoldEvent(Ticket ticket, Instant selledAt) {
}
