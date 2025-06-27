package carlos.silva.ingressos.domain.ticket;

import static com.google.common.base.Preconditions.checkNotNull;

import java.time.Instant;

import org.springframework.data.domain.AbstractAggregateRoot;

import carlos.silva.ingressos.domain.DomainException;
import carlos.silva.ingressos.domain.event.EventId;
import carlos.silva.ingressos.domain.user.UserId;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = "id", callSuper = false)
public class Ticket extends AbstractAggregateRoot<Ticket> {
    @Getter
    private final TicketId id;
    @Getter
    private final EventId eventId;
    @Getter
    private final int price;
    @Getter
    private UserId userId;
    @Getter
    private Instant selledAt;

    public Ticket(TicketId id, EventId eventId, int price, UserId userId, Instant selledAt) {
        if (price < 0) {
            throw new DomainException("Ticket price can not be negative");
        }

        this.id = checkNotNull(id);
        this.eventId = checkNotNull(eventId);
        this.price = price;
        this.userId = userId;
        this.selledAt = selledAt;
    }

    public void sell(UserId userId) {
        if (!isAvailable())
            throw new DomainException("Ticket is already selled");
        registerEvent(new TicketSoldEvent(this, Instant.now()));
    }

    public boolean isAvailable() {
        return userId == null;
    }
}
