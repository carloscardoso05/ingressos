package carlos.silva.ingressos.domain.value_objects;

import static com.google.common.base.Preconditions.checkNotNull;

import carlos.silva.ingressos.domain.DomainException;

public record EventName(String value) {
    public EventName {
        checkNotNull(value);
        if (value.isBlank()) {
            throw new DomainException("EventName value must not be blank");
        }
    }
}
