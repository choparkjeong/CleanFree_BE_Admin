package site.cleanfree.be_admin.recommendation.infrastructure;


import org.springframework.data.mongodb.repository.MongoRepository;
import site.cleanfree.be_admin.recommendation.domain.Recommendation;

import java.util.List;
import java.util.Optional;

public interface RecommendationRepository extends MongoRepository<Recommendation, String> {

    Optional<Recommendation> getRecommendationByResultId(String resultId);

    List<Recommendation> getAllByMemberUuid(String memberUuid);

    List<Recommendation> findAllByOrderByCreatedAtDesc();

    List<Recommendation> findFirstByMemberUuidInOrderByCreatedAtAsc(List<String> memberUuids);
}
