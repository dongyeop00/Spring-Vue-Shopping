package dongyeop.backend.Repository;

import dongyeop.backend.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    Member findByEmailAndPassword(String email, String password);
}
