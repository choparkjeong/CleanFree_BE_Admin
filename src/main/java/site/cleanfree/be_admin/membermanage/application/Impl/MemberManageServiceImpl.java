package site.cleanfree.be_admin.membermanage.application.Impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.cleanfree.be_admin.common.BaseResponse;
import site.cleanfree.be_admin.common.TimeConvertor;
import site.cleanfree.be_admin.membermanage.application.MemberManageService;
import site.cleanfree.be_admin.membermanage.domain.Member;
import site.cleanfree.be_admin.membermanage.dto.MemberInfoDto;
import site.cleanfree.be_admin.membermanage.infrastructure.MemberManageRepository;
import site.cleanfree.be_admin.recommendation.domain.Recommendation;
import site.cleanfree.be_admin.recommendation.infrastructure.RecommendationRepository;


@Slf4j
@Service
@RequiredArgsConstructor
public class MemberManageServiceImpl implements MemberManageService {

    private final MemberManageRepository memberManageRepository;
    private final RecommendationRepository recommendationRepository;

    @Override
    @Transactional(readOnly = true)
    public BaseResponse<List<MemberInfoDto>> getMemberInfos() {
        List<Member> members = memberManageRepository.findAll();

        if (members.isEmpty()) {
            return BaseResponse.<List<MemberInfoDto>>builder()
                .success(true)
                .errorCode(null)
                .message("there are no members")
                .data(null)
                .build();
        }

        List<String> memberUuids = members.stream()
            .map(Member::getUuid)
            .toList();

        List<Recommendation> firstRecommendations = recommendationRepository
            .findFirstByMemberUuidInOrderByCreatedAtAsc(memberUuids);

        if (firstRecommendations.isEmpty()) {
            return BaseResponse.<List<MemberInfoDto>>builder()
                .success(true)
                .errorCode(null)
                .message("there are no recommendations")
                .data(null)
                .build();
        }

        // UUID를 키로 하고 첫 번째 검색 시간을 값으로 하는 Map 생성
        Map<String, LocalDateTime> firstSearchTimeMap = firstRecommendations.stream()
            .filter(rec -> rec != null && rec.getMemberUuid() != null && rec.getCreatedAt() != null)
            .collect(Collectors.toMap(
                Recommendation::getMemberUuid,
                Recommendation::getCreatedAt,
                (existing, replacement) -> existing
            ));

        log.info("firstSearchTimeMap: {}", firstSearchTimeMap);

        List<MemberInfoDto> memberInfoDtos = members.stream()
            .map(member -> MemberInfoDto.builder()
                .name(member.getName())
                .email(member.getEmail())
                .gender(member.getGender())
                .birthDate(member.getBirthDate())
                .totalSearchCount(member.getTotalSearchCount())
                .dayAccessCount(member.getDayAccessCount())
                .firstSearchTime(firstSearchTimeMap.get(member.getUuid()) == null ?
                        null : TimeConvertor.utcToKst(firstSearchTimeMap.get(member.getUuid())).format(
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .lastSearchTime(member.getUpdatedAt() ==null ? null : TimeConvertor.utcToKst(member.getUpdatedAt()).format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build())
            .toList();

        return BaseResponse.<List<MemberInfoDto>>builder()
            .success(true)
            .errorCode(null)
            .message("find all member")
            .data(memberInfoDtos)
            .build();
    }
}
