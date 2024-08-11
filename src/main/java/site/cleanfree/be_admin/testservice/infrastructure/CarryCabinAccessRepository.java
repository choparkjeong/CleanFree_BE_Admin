package site.cleanfree.be_admin.testservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import site.cleanfree.be_admin.testservice.domain.CarryCabinAccess;

public interface CarryCabinAccessRepository extends MongoRepository<CarryCabinAccess, String> {

}
