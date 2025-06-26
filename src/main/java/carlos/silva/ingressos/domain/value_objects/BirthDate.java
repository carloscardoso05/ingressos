package carlos.silva.ingressos.domain.value_objects;

import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDate;

import carlos.silva.ingressos.domain.DomainException;

public record BirthDate(LocalDate value) {
    public BirthDate {
        checkNotNull(value);
        if (value.isAfter(LocalDate.now())) {
            throw new DomainException("BirthDate value must be on the past");
        }
    }

}
