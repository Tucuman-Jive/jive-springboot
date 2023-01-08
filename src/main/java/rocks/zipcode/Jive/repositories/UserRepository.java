package rocks.zipcode.Jive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rocks.zipcode.Jive.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
