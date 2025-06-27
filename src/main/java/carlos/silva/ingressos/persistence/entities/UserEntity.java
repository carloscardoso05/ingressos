package carlos.silva.ingressos.persistence.entities;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import carlos.silva.ingressos.persistence.entities.base.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Table(name = "users_data")
@Entity
@Getter
@Setter
public class UserEntity extends AuditableEntity {
    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotNull
    private LocalDate birthDate;

    @Column(nullable = false, length = 11)
    @CPF
    @NotNull
    private String cpf;

    public UserEntity() {
    }

    public UserEntity(@NotNull UUID id, @NotBlank String name, @NotNull LocalDate birthDate, @CPF @NotNull String cpf) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
    }
}
