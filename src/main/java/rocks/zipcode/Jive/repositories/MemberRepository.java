package rocks.zipcode.Jive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rocks.zipcode.Jive.entities.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
