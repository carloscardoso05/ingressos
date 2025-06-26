package carlos.silva.ingressos.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carlos.silva.ingressos.persistence.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}
