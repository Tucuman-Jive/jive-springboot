package rocks.zipcode.Jive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rocks.zipcode.Jive.entities.Channel;
import rocks.zipcode.Jive.entities.Membership;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    List<Channel> findAll();

}
