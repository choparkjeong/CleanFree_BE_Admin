package site.cleanfree.be_admin.auth.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import site.cleanfree.be_admin.auth.domain.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByAdminId(String id);

    Optional<Admin> findByAdminUuid(String uuid);
}
