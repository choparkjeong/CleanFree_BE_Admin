package site.cleanfree.be_admin.membermanage.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.cleanfree.be_admin.membermanage.domain.Member;

@Repository
public interface MemberManageRepository extends JpaRepository<Member, Long> {

}
