package site.cleanfree.be_admin.testservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import site.cleanfree.be_admin.testservice.domain.CozyHouse;

public interface CozyHouseRepository extends MongoRepository<CozyHouse, String> {

}
