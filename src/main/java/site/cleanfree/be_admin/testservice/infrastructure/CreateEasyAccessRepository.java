package site.cleanfree.be_admin.testservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import site.cleanfree.be_admin.testservice.domain.CreateEasyAccess;

public interface CreateEasyAccessRepository extends MongoRepository<CreateEasyAccess, String> {

}
