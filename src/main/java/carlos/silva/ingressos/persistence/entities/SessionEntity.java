package carlos.silva.ingressos.persistence.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import carlos.silva.ingressos.persistence.entities.base.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Table(name = "sessions")
@Entity
@Getter
@Setter
public class SessionEntity extends AuditableEntity {
    private String name;

    @ManyToOne(optional = false)
    @NotNull
    private EventEntity event;

    @Column(name = "session_start", nullable = false)
    @NotNull
    private LocalDateTime start;

    @Column(name = "session_end", nullable = false)
    @NotNull
    private LocalDateTime end;

    public SessionEntity() {
    }

    public SessionEntity(UUID id, String name, @NotNull EventEntity event, @NotNull LocalDateTime start,
            @NotNull LocalDateTime end) {
        this.id = id;
        this.name = name;
        this.event = event;
        this.start = start;
        this.end = end;
    }

}
