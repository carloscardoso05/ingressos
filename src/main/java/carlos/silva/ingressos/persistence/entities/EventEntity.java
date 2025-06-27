package carlos.silva.ingressos.persistence.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import carlos.silva.ingressos.persistence.entities.base.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column(nullable = false)
    @Future
    private LocalDateTime start;

    @Column(nullable = false)
    @Future
    private LocalDateTime end;

    @Column
    @PositiveOrZero
    private Integer minimalAge;

    public EventEntity() {
    }

    public EventEntity(UUID id, @NotBlank String name, @NotNull String description, @Future LocalDateTime start,
            @Future LocalDateTime end, @PositiveOrZero Integer minimalAge) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.minimalAge = minimalAge;
    }
}
