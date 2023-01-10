package rocks.zipcode.Jive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rocks.zipcode.Jive.entities.Message;

@Repository
public interface ChannelMessageRepository extends JpaRepository<Message, Long> {
}
