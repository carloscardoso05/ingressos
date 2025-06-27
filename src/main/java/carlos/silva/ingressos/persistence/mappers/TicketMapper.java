package carlos.silva.ingressos.persistence.mappers;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import carlos.silva.ingressos.domain.event.EventId;
import carlos.silva.ingressos.domain.ticket.Ticket;
import carlos.silva.ingressos.domain.ticket.TicketId;
import carlos.silva.ingressos.domain.user.UserId;
import carlos.silva.ingressos.persistence.entities.TicketEntity;
import carlos.silva.ingressos.persistence.repositories.EventEntityRepository;
import carlos.silva.ingressos.persistence.repositories.UserEntityRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Component
@Validated
@RequiredArgsConstructor
public class TicketMapper {

    private final EventEntityRepository eventEntityRepository;
    private final UserEntityRepository userEntityRepository;

    public TicketEntity fromDomain(@NotNull Ticket ticket) {
        TicketEntity entity = new TicketEntity();
        entity.setId(ticket.getId().value());
        entity.setEvent(eventEntityRepository.findById(ticket.getEventId().value()).orElseThrow());
        entity.setPrice(ticket.getPrice());
        if (ticket.getUserId() != null)
            entity.setUser(userEntityRepository.findById(ticket.getUserId().value()).orElseThrow());
        entity.setSelledAt(ticket.getSelledAt());

        return entity;
    }

    public Ticket toDomain(@NotNull TicketEntity ticketEntity) {
        return new Ticket(
                new TicketId(ticketEntity.getId()),
                new EventId(ticketEntity.getEvent().getId()),
                ticketEntity.getPrice(),
                ticketEntity.getUser() != null ? new UserId(ticketEntity.getUser().getId()) : null,
                ticketEntity.getSelledAt());
    }
}
