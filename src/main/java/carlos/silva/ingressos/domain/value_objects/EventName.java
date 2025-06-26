package carlos.silva.ingressos.domain.value_objects;

import com.google.common.base.Strings;

import carlos.silva.ingressos.domain.DomainException;

public record EventName(String value) {
    public EventName {
        if (Strings.isNullOrEmpty(value) || value.isBlank()) {
            throw new DomainException("EventName value must not be null or blank");
        }
    }
}
