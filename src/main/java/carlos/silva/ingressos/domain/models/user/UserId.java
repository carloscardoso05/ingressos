package carlos.silva.ingressos.domain.models.user;

import java.util.UUID;

import org.springframework.util.Assert;

public record UserId(UUID value) {
    public UserId() {
        this(UUID.randomUUID());
    }

    public UserId {
        Assert.notNull(value, "Value must not be null");
    }
}
