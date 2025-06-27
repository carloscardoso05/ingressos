package carlos.silva.ingressos.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carlos.silva.ingressos.persistence.entities.EventEntity;

@Repository
public interface EventEntityRepository extends JpaRepository<EventEntity, UUID> {

}
