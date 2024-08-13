package site.cleanfree.be_admin.testservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import site.cleanfree.be_admin.testservice.domain.CreateValue;

public interface CreateValueRepository extends MongoRepository<CreateValue, String> {

}
