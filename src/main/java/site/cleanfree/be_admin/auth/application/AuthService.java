package site.cleanfree.be_admin.auth.application;


import site.cleanfree.be_admin.auth.data.dto.AdminSignUpDto;
import site.cleanfree.be_admin.auth.data.vo.AdminSignInRequestVo;
import site.cleanfree.be_admin.auth.data.vo.AdminSignUpRequestVo;

public interface AuthService {

    AdminSignUpDto signUp(AdminSignUpRequestVo adminSignUpRequestVo);

    String signIn(AdminSignInRequestVo adminSignInRequestVo);
}
