package carlos.silva.ingressos.persistence.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import carlos.silva.ingressos.persistence.entities.base.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Table(name = "events")
@Entity
@Getter
@Setter
public class EventEntity extends AuditableEntity {
    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotNull
    private String description = "";

    @Column(nullable = false, name = "event_start")
    @Future
    private LocalDateTime start;

    @Column(nullable = false, name = "event_end")
    @Future
    private LocalDateTime end;

    @Column
    @PositiveOrZero
    private Integer minimalAge;

    @OneToMany(mappedBy = "event")
    private final List<SessionEntity> sessions = new ArrayList<>();

    public EventEntity() {
    }

    public EventEntity(UUID id, @NotBlank String name, @NotNull String description, @Future LocalDateTime start,
            @Future LocalDateTime end, @PositiveOrZero Integer minimalAge, List<SessionEntity> sessions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.minimalAge = minimalAge;
        this.sessions.addAll(sessions);
    }
}
