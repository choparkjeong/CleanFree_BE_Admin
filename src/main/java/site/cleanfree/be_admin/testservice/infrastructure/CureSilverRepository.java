package site.cleanfree.be_admin.testservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import site.cleanfree.be_admin.testservice.domain.CureSilver;

public interface CureSilverRepository extends MongoRepository<CureSilver, String> {

}
