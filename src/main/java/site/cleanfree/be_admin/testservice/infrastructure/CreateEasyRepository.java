package site.cleanfree.be_admin.testservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import site.cleanfree.be_admin.testservice.domain.CreateEasy;
import site.cleanfree.be_admin.testservice.domain.CreateEasyAccess;

public interface CreateEasyRepository extends MongoRepository<CreateEasy, String> {

}
