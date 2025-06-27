package carlos.silva.ingressos.persistence.entities;

import java.time.Instant;
import java.util.UUID;

import carlos.silva.ingressos.persistence.entities.base.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tickets")
@Entity
@Getter
@Setter
public class TicketEntity extends AuditableEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    @NotNull
    private EventEntity event;

    @Column(nullable = false)
    @PositiveOrZero
    private int price;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    private UserEntity user;

    @Column(nullable = false)
    @NotNull
    @FutureOrPresent
    private Instant selledAt;

    public TicketEntity() {
    }

    public TicketEntity(UUID id, @NotNull EventEntity event, @PositiveOrZero int price, UserEntity user,
            @NotNull @FutureOrPresent Instant selledAt) {
        this.id = id;
        this.event = event;
        this.price = price;
        this.user = user;
        this.selledAt = selledAt;
    }
}
