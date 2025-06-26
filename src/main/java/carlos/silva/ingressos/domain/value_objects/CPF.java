package carlos.silva.ingressos.domain.value_objects;

import static com.google.common.base.Preconditions.checkNotNull;

import br.com.caelum.stella.validation.CPFValidator;

public record CPF(String value) {
	public CPF(String value) {
		checkNotNull(value, "Value for CPF must not be null");
		value = value.trim().replaceAll("[^0-9]", "");
		CPFValidator validator = new CPFValidator();
		try {
			validator.assertValid(value);
		} catch (Exception e) {
			throw new IllegalArgumentException("CPF value %s is invalid".formatted(value));
		}
		this.value = value;
	}

}
