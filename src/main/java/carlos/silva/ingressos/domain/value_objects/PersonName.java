package carlos.silva.ingressos.domain.value_objects;

import static com.google.common.base.Preconditions.checkNotNull;

import carlos.silva.ingressos.domain.DomainException;

public record PersonName(String value) {
    public PersonName {
        checkNotNull(value);
        if (value.isEmpty()) {
            throw new DomainException("PersonName value must not be blank. Actual: '%s'".formatted(value));
        }
    }
}
