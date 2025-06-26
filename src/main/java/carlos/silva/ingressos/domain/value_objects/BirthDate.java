package carlos.silva.ingressos.domain.value_objects;

import java.time.LocalDate;

import carlos.silva.ingressos.domain.DomainException;

public record BirthDate(LocalDate value) {
    public BirthDate {
        if (value == null) {
            throw new DomainException("BirthDate value must not be null");
        }
        if (value.isAfter(LocalDate.now())) {
            throw new DomainException("BirthDate value must be on the past");
        }
    }

}
