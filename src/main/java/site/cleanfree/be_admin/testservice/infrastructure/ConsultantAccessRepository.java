package site.cleanfree.be_admin.testservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import site.cleanfree.be_admin.testservice.domain.ConsultantAccess;

public interface ConsultantAccessRepository extends MongoRepository<ConsultantAccess, String> {

}
