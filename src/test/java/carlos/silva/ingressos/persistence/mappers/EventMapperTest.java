package carlos.silva.ingressos.persistence.mappers;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import carlos.silva.ingressos.persistence.entities.EventEntity;
import jakarta.validation.ConstraintViolationException;

@SpringBootTest()
public class EventMapperTest {
	@Autowired
	private EventMapper eventMapper;

	@Test
	public void toDomain() {
		EventEntity eventEntity = new EventEntity(UUID.randomUUID(), "abc", "abc", LocalDateTime.now(),
				LocalDateTime.now(), 123, List.of());

		assertDoesNotThrow(() -> eventMapper.toDomain(eventEntity));
		assertThrows(ConstraintViolationException.class, () -> eventMapper.fromDomain(null));
		assertThrows(ConstraintViolationException.class, () -> eventMapper.toDomain(null));
	}

}
