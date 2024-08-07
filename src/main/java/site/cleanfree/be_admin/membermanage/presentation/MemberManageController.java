package site.cleanfree.be_admin.membermanage.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.cleanfree.be_admin.common.BaseResponse;
import site.cleanfree.be_admin.membermanage.application.MemberManageService;
import site.cleanfree.be_admin.membermanage.dto.MemberInfoDto;

@RestController
@RequestMapping("/api/v1/admin/member-manage")
@RequiredArgsConstructor
@Tag(name = "회원 관리 API", description = "회원 관리 API")
public class MemberManageController {

    private final MemberManageService memberManageService;

    @GetMapping("/all")
    @Operation(summary = "회원 목록 조회 API", description = "모든 회원 정보를 조회합니다.")
    public ResponseEntity<BaseResponse<List<MemberInfoDto>>> getAllMemberInfos(
        @RequestHeader String Authorization
    ) {
        return ResponseEntity.ok(memberManageService.getMemberInfos());
    }
}
