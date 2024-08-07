package site.cleanfree.be_admin.membermanage.application.Impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.cleanfree.be_admin.common.BaseResponse;
import site.cleanfree.be_admin.membermanage.application.MemberManageService;
import site.cleanfree.be_admin.membermanage.domain.Member;
import site.cleanfree.be_admin.membermanage.dto.MemberInfoDto;
import site.cleanfree.be_admin.membermanage.infrastructure.MemberManageRepository;


@Service
@RequiredArgsConstructor
public class MemberManageServiceImpl implements MemberManageService {

    private final MemberManageRepository memberManageRepository;

    @Override
    @Transactional("")
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

        return BaseResponse.<List<MemberInfoDto>>builder()
            .success(true)
            .errorCode(null)
            .message("find all member")
            .data(members.stream().map(member ->
                MemberInfoDto.builder()
                    .name(member.getName())
                    .email(member.getEmail())
                    .gender(member.getGender())
                    .birthDate(member.getBirthDate())
                    .totalSearchCount(member.getTotalSearchCount())
                    .dayAccessCount(member.getDayAccessCount())
                    .build()).toList())
            .build();
    }
}
