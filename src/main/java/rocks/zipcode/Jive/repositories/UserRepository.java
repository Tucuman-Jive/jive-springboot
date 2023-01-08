package rocks.zipcode.Jive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocks.zipcode.Jive.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
