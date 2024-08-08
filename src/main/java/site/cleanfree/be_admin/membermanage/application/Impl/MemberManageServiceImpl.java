package site.cleanfree.be_admin.membermanage.application.Impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.cleanfree.be_admin.common.BaseResponse;
import site.cleanfree.be_admin.membermanage.application.MemberManageService;
import site.cleanfree.be_admin.membermanage.domain.Member;
import site.cleanfree.be_admin.membermanage.dto.FirstAndLastQuestionTime;
import site.cleanfree.be_admin.membermanage.infrastructure.MemberManageRepository;
import site.cleanfree.be_admin.recommendation.infrastructure.RecommendationRepository;


@Slf4j
@Service
@RequiredArgsConstructor
public class MemberManageServiceImpl implements MemberManageService {

    private final MongoTemplate mongoTemplate;
    private final MemberManageRepository memberManageRepository;
    private final RecommendationRepository recommendationRepository;

    @Override
    @Transactional(readOnly = true)
    public BaseResponse<List<FirstAndLastQuestionTime>> getMemberInfos() {
        List<Member> members = memberManageRepository.findAll();

        if (members.isEmpty()) {
            return BaseResponse.<List<FirstAndLastQuestionTime>>builder()
                .success(true)
                .errorCode(null)
                .message("there are no members")
                .data(null)
                .build();
        }

        List<FirstAndLastQuestionTime> firstAndLastQuestionTimes = findFirstAndLastRecommendationsByMemberUuids(
            members);

        if (firstAndLastQuestionTimes.isEmpty()) {
            return BaseResponse.<List<FirstAndLastQuestionTime>>builder()
                .success(true)
                .errorCode(null)
                .message("there are no recommendations")
                .data(null)
                .build();
        }

        return BaseResponse.<List<FirstAndLastQuestionTime>>builder()
            .success(true)
            .errorCode(null)
            .message("find all member")
            .data(firstAndLastQuestionTimes)
            .build();
    }

    private List<FirstAndLastQuestionTime> findFirstAndLastRecommendationsByMemberUuids(
        List<Member> members) {

        Map<String, Member> memberUuidToMemberMap = members.stream()
            .collect(Collectors.toMap(Member::getUuid, member -> member));

        Set<String> memberUuids = memberUuidToMemberMap.keySet();

        MatchOperation matchOperation = Aggregation.match(
            Criteria.where("memberUuid").in(memberUuids));

        GroupOperation groupOperation = Aggregation.group("memberUuid")
            .min("createdAt").as("firstSearchTime")
            .max("createdAt").as("lastSearchTime");

        ProjectionOperation projectionOperation = Aggregation.project()
            .and("_id").as("memberUuid")
            .and("firstSearchTime").as("firstSearchTime")
            .and("lastSearchTime").as("lastSearchTime");

        SortOperation sortOperation = Aggregation.sort(Sort.Direction.DESC, "lastSearchTime");

        Aggregation aggregation = Aggregation.newAggregation(
            matchOperation,
            groupOperation,
            projectionOperation,
            sortOperation
        );

        AggregationResults<FirstAndLastQuestionTime> results = mongoTemplate.aggregate(
            aggregation, "recommendation_service", FirstAndLastQuestionTime.class);

        return results.getMappedResults()
            .stream()
            .map(result -> {
                String memberUuid = result.getMemberUuid();
                Member member = memberUuidToMemberMap.get(memberUuid);
                if (member != null) {
                    result.setName(member.getName());
                    result.setEmail(member.getEmail());
                    result.setGender(member.getGender());
                    result.setBirthDate(member.getBirthDate());
                    result.setTotalSearchCount(member.getTotalSearchCount());
                    result.setDayAccessCount(member.getDayAccessCount());
                    result.convertKst();
                }
                return result;
            }).toList();
    }

}
