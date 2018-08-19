package examples.boot.web1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member, Long> {
}
