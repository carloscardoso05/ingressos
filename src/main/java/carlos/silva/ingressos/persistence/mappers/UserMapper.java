package carlos.silva.ingressos.persistence.mappers;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import carlos.silva.ingressos.domain.models.user.User;
import carlos.silva.ingressos.domain.models.user.UserId;
import carlos.silva.ingressos.domain.models.value_objects.BirthDate;
import carlos.silva.ingressos.domain.models.value_objects.CPF;
import carlos.silva.ingressos.domain.models.value_objects.PersonName;
import carlos.silva.ingressos.persistence.entities.UserEntity;
import jakarta.validation.constraints.NotNull;

@Component
@Validated
public class UserMapper {

    public UserEntity fromDomain(@NotNull User user) {
        return new UserEntity(
                user.getId().value(),
                user.getName().value(),
                user.getBirthDate().value(),
                user.getCpf().value());
    }

    public User toDomain(@NotNull UserEntity userEntity) {
        return new User(
                new UserId(userEntity.getId()),
                new PersonName(userEntity.getName()),
                new BirthDate(userEntity.getBirthDate()),
                new CPF(userEntity.getCpf()));
    }
}
