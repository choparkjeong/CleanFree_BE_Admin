package site.cleanfree.be_admin.auth.application;


import site.cleanfree.be_admin.auth.dto.AdminSignupDto;

public interface AuthService {
    AdminSignupDto signup(AdminSignupDto adminSignupRequestDto);
}
