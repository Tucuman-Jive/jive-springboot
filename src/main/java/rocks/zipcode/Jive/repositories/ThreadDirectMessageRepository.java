package rocks.zipcode.Jive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rocks.zipcode.Jive.entities.ThreadDirectMessage;

@Repository
public interface ThreadDirectMessageRepository extends JpaRepository<ThreadDirectMessage, Long> {
}
