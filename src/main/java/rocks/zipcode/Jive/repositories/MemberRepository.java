package rocks.zipcode.Jive.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rocks.zipcode.Jive.entities.Membership;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Membership, Long> {
    List<Membership> findByChannelId(Long id); // do this for messages?

    List<Membership> findByChannelName(String channelName);

    List<Membership> getByUserEntityId(Long id);

    List<Membership> findAll();
}
