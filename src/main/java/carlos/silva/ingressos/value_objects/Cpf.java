package carlos.silva.ingressos.value_objects;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public record Cpf(
                @CPF @NotNull @Column(name = "cpf", unique = true, nullable = false, columnDefinition = "char(11)") String value) {
        public Cpf {
                value = value.replace("[^0-9]", "");
        }

}
