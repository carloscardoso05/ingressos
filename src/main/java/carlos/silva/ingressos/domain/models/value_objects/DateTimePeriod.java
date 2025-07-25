package carlos.silva.ingressos.domain.models.value_objects;

import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDateTime;

import carlos.silva.ingressos.domain.DomainException;

public record DateTimePeriod(LocalDateTime start, LocalDateTime end) {
    public DateTimePeriod {
        checkNotNull(start, "Start DateTime must not be null");
        checkNotNull(end, "End DateTime must not be null");
        if (start.isAfter(LocalDateTime.now())) {
            throw new DomainException("Start DateTime must be on the future");
        }
        if (end.isAfter(start)) {
            throw new DomainException("End DateTime must be after the start");
        }
    }
}
