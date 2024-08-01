package site.cleanfree.be_admin.auth.application;


import site.cleanfree.be_admin.auth.data.dto.AdminSignupDto;
import site.cleanfree.be_admin.auth.data.vo.AdminSignupRequestVo;

public interface AuthService {
    AdminSignupDto signup(AdminSignupRequestVo adminSignupRequestVo);
}
