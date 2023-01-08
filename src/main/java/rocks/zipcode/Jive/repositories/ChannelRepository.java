package rocks.zipcode.Jive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rocks.zipcode.Jive.entities.Channel;


@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
