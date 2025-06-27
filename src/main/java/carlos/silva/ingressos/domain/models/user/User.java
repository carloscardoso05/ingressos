package carlos.silva.ingressos.domain.models.user;

import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDate;
import java.time.Period;

import carlos.silva.ingressos.domain.models.event.Event;
import carlos.silva.ingressos.domain.models.value_objects.BirthDate;
import carlos.silva.ingressos.domain.models.value_objects.CPF;
import carlos.silva.ingressos.domain.models.value_objects.PersonName;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = "id")
public class User {
    public static final int LEGAL_AGE = 18;

    @Getter
    private final UserId id;
    @Getter
    private PersonName name;
    @Getter
    private BirthDate birthDate;
    @Getter
    private CPF cpf;

    public User(UserId id, PersonName name, BirthDate birthDate, CPF cpf) {
        this.id = checkNotNull(id, "Id must not be null");
        this.name = checkNotNull(name, "Name must not be null");
        this.birthDate = checkNotNull(birthDate, "BirthDate must not be null");
        this.cpf = checkNotNull(cpf, "CPF must not be null");
    }

    public void changeName(PersonName newName) {
        name = checkNotNull(newName, "newName must not be null");
    }

    public int getAge() {
        return Period.between(birthDate.value(), LocalDate.now()).getYears();
    }

    public boolean isLegalAge() {
        return getAge() >= LEGAL_AGE;
    }

    public boolean canParticipate(Event event) {
        if (event.hasEnded())
            return false;
        Integer minimalAge = event.getMinimalAge();
        if (minimalAge == null)
            return true;
        return getAge() >= minimalAge;
    }
}
