package carlos.silva.ingressos.domain.value_objects;

import static com.google.common.base.Preconditions.checkNotNull;

import br.com.caelum.stella.validation.CPFValidator;
import carlos.silva.ingressos.domain.DomainException;

public record CPF(String value) {
	public CPF(String value) {
		checkNotNull(value, "Value for CPF must not be null");
		value = value.trim().replaceAll("[^0-9]", "");
		CPFValidator validator = new CPFValidator();
		try {
			validator.assertValid(value);
		} catch (Exception e) {
			throw new DomainException("CPF value %s is invalid".formatted(value));
		}
		this.value = value;
	}

}
