package site.cleanfree.be_admin.auth.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.cleanfree.be_admin.auth.data.vo.AdminSignInRequestVo;
import site.cleanfree.be_admin.auth.data.vo.AdminSignUpRequestVo;
import site.cleanfree.be_admin.auth.domain.Admin;
import site.cleanfree.be_admin.auth.data.dto.AdminSignUpDto;
import site.cleanfree.be_admin.auth.infrastructure.AdminRepository;
import site.cleanfree.be_admin.common.UuidProvider;
import site.cleanfree.be_admin.common.exception.CustomException;
import site.cleanfree.be_admin.common.exception.ErrorMessage;
import site.cleanfree.be_admin.common.exception.ErrorStatus;
import site.cleanfree.be_admin.security.JwtTokenProvider;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final AdminRepository adminRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public AdminSignUpDto signUp(AdminSignUpRequestVo adminSignUpRequestVo) {
        // pw 암호화해서 저장
        Admin admin = Admin.builder()
                .adminId(adminSignUpRequestVo.getId())
                .adminPw(hashPassword(adminSignUpRequestVo.getPw()))
                .adminUuid(UuidProvider.generateAdminUuid())
                .build();

        try {
            adminRepository.save(admin);
        } catch (Exception e) {
            log.error("Sign Up Error : {}", e.getMessage());
            throw new CustomException(ErrorStatus.DUPLICATE_ID, ErrorMessage.DUPLICATE_ID);
        }

        return AdminSignUpDto.builder()
                .id(admin.getAdminId())
                .pw(admin.getAdminPw())
                .adminUuid(admin.getAdminUuid())
                .build();
    }

    @Override
    public String signIn(AdminSignInRequestVo adminSignInRequestVo) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // id를 통해 pw를 조회
        Admin admin = adminRepository.findByAdminId(adminSignInRequestVo.getId())
                .orElseThrow(
                        () -> new CustomException(ErrorStatus.INCORRECT_ID, ErrorMessage.ID_NOT_EXISTED)
                );

        // 비밀번호 매칭
        if (!(encoder.matches(adminSignInRequestVo.getPw(), admin.getAdminPw()))) {
            throw new CustomException(ErrorStatus.INCORRECT_PW, ErrorMessage.INCORRECT_PASSWORD);
        }

        // 토큰 반환
        return createToken(admin.getAdminUuid());
    }

    private String hashPassword(String userPassword) {
        return new BCryptPasswordEncoder().encode(userPassword);
    }

    private String createToken(String uuid) {
        UserDetails userDetails = User.withUsername(uuid).password(uuid)
                .roles("USER").build();
        return jwtTokenProvider.generateToken(userDetails);
    }
}
