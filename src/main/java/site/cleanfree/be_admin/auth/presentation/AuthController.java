package site.cleanfree.be_admin.auth.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.cleanfree.be_admin.auth.application.AuthService;
import site.cleanfree.be_admin.auth.data.dto.AdminSignUpDto;
import site.cleanfree.be_admin.auth.data.vo.AdminSignInRequestVo;
import site.cleanfree.be_admin.auth.data.vo.AdminSignUpRequestVo;
import site.cleanfree.be_admin.common.BaseResponse;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "관리자", description = "관리자 API")
@RequestMapping("/api/v1/admin/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signUp")
    @Operation(summary = "회원가입 API", description = "회원가입 API")
    public ResponseEntity<BaseResponse<Object>> signup(
            @RequestHeader String Authorization,
            @RequestBody AdminSignUpRequestVo adminSignUpRequestVo) {

        AdminSignUpDto adminSignupDto = authService.signUp(adminSignUpRequestVo);
        log.info("New Admin Acount : {}", adminSignupDto.toString());
        return ResponseEntity.ok()
                .body(BaseResponse.successResponse("SignUp Success", adminSignupDto.toString()));
    }

    @PostMapping("/signIn")
    @Operation(summary = "로그인 API", description = "로그인 API")
    public ResponseEntity<BaseResponse<Object>> signIn(
            @RequestBody AdminSignInRequestVo adminSignInRequestVo) {

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, authService.signIn(adminSignInRequestVo))
                .body(BaseResponse.successResponse("SignIn Success"));
    }
}
