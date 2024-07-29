package site.cleanfree.be_admin.auth.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import site.cleanfree.be_admin.auth.domain.Admin;
import site.cleanfree.be_admin.auth.dto.AdminSignupDto;
import site.cleanfree.be_admin.auth.infrastructure.AdminRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final AdminRepository adminRepository;

    @Override
    public AdminSignupDto signup(AdminSignupDto adminSignupRequestDto) {
        // pw 암호화해서 저장
        Admin admin = Admin.builder()
                .adminId(adminSignupRequestDto.getId())
                .adminPw(hashPassword(adminSignupRequestDto.getPw()))
                .build();
        adminRepository.save(admin);

        return AdminSignupDto.builder()
                .id(admin.getAdminId())
                .pw(admin.getAdminPw())
                .build();
    }

    private String hashPassword(String userPassword) {
        return new BCryptPasswordEncoder().encode(userPassword);
    }
}
