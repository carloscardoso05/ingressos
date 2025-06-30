package carlos.silva.ingressos.persistence.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carlos.silva.ingressos.persistence.entities.SessionEntity;

@Repository
public interface SessionEntityRepository extends JpaRepository<SessionEntity, UUID> {
    List<SessionEntity> findAllByEventId(UUID id);
}
