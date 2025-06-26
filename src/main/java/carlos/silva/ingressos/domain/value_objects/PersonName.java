package carlos.silva.ingressos.domain.value_objects;

import com.google.common.base.Strings;

import carlos.silva.ingressos.domain.DomainException;

public record PersonName(String value) {
    public PersonName {
        if (Strings.isNullOrEmpty(value) || value.isEmpty()) {
            throw new DomainException("PersonName value must not be null or blank. Actual: '%s'".formatted(value));
        }
    }
}
