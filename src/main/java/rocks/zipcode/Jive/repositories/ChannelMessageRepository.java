package rocks.zipcode.Jive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rocks.zipcode.Jive.entities.ChannelMessage;

@Repository
public interface ChannelMessageRepository extends JpaRepository<ChannelMessage, Long> {
}
