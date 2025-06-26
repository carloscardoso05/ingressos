package carlos.silva.ingressos.domain.value_objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDateTime;

public record EventPeriod(LocalDateTime start, LocalDateTime end) {
    public EventPeriod {
        checkNotNull(start, "Start DateTime must not be null");
        checkNotNull(end, "End DateTime must not be null");
        checkArgument(start.isAfter(LocalDateTime.now()), "Start DateTime must be on the future");
        checkArgument(end.isAfter(start), "End DateTime must be after the start");
    }
}
