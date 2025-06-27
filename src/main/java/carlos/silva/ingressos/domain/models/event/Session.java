package carlos.silva.ingressos.domain.models.event;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import carlos.silva.ingressos.domain.models.value_objects.DateTimePeriod;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = "id")
public class Session {
    @Getter
    private SessionId id;

    @Getter
    private EventId eventId;

    @Getter
    private String name;

    @Getter
    private DateTimePeriod period;

    public Session(SessionId id, EventId eventId, String name, DateTimePeriod period) {
        checkArgument(name != null && !name.isBlank());
        this.id = checkNotNull(id);
        this.eventId = checkNotNull(eventId);
        this.name = name;
        this.period = checkNotNull(period);
    }

    

}
