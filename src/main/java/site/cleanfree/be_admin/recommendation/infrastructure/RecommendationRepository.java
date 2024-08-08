package site.cleanfree.be_admin.recommendation.infrastructure;


import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import site.cleanfree.be_admin.recommendation.domain.Recommendation;

import java.util.List;
import java.util.Optional;

public interface RecommendationRepository extends MongoRepository<Recommendation, String> {

    Optional<Recommendation> getRecommendationByResultId(String resultId);

    List<Recommendation> getAllByMemberUuid(String memberUuid);

    List<Recommendation> findAllByOrderByCreatedAtDesc();

    @Aggregation(pipeline = {
        "{ $match: { memberUuid: { $in: ?0 } } }",
        "{ $group: { _id: '$memberUuid', oldestRecommendation: { $first: '$$ROOT' } } }",
        "{ $replaceRoot: { newRoot: '$oldestRecommendation' } }",
        "{ $sort: { createdAt: 1 } }"
    })
    List<Recommendation> findOldestRecommendationsByMemberUuids(List<String> memberUuids);
}
