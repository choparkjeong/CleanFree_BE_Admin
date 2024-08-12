package site.cleanfree.be_admin.testservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import site.cleanfree.be_admin.testservice.domain.VisaAccess;

public interface VisaAccessRepository extends MongoRepository<VisaAccess, String> {

}
