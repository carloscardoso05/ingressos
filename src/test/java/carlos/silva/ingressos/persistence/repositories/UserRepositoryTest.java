package carlos.silva.ingressos.persistence.repositories;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class UserRepositoryTest {

    private final UserEntityRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    void Given_a_valid_user_when_save_should_save_user() {
        System.out.println(userRepository);
    }

}
