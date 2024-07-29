package site.cleanfree.be_admin.auth.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.cleanfree.be_admin.auth.application.AuthService;
import site.cleanfree.be_admin.auth.dto.AdminSignupDto;
import site.cleanfree.be_admin.common.BaseResponse;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "관리자", description = "관리자 API")
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입 API", description = "회원가입 API")
    public ResponseEntity<BaseResponse<Object>> signup(
            @RequestBody AdminSignupDto adminSignupRequestDto) {
        AdminSignupDto adminSignupResponseDto = authService.signup(adminSignupRequestDto);

        return ResponseEntity.ok()
                .body(BaseResponse.successResponse("SignUp Success.", adminSignupResponseDto.toString()));
    }
}
