package carlos.silva.ingressos.domain.ticket;

import static com.google.common.base.Preconditions.checkNotNull;

import carlos.silva.ingressos.domain.DomainException;
import carlos.silva.ingressos.domain.event.EventId;
import carlos.silva.ingressos.domain.user.UserId;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = "id")
public class Ticket {
    @Getter
    private final TicketId id;
    @Getter
    private final EventId eventId;
    @Getter
    private final int price;
    @Getter
    private UserId userId;

    public Ticket(TicketId id, int price, EventId eventId) {
        if (price < 0) {
            throw new DomainException("Ticket price can not be negative");
        }

        this.id = checkNotNull(id);
        this.price = price;
        this.eventId = checkNotNull(eventId);
    }

    public void sell(UserId userId) {
        this.userId = checkNotNull(userId);
    }

}
