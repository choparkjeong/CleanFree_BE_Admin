package site.cleanfree.be_admin.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import site.cleanfree.be_admin.auth.infrastructure.AdminRepository;
import site.cleanfree.be_admin.common.exception.CustomException;
import site.cleanfree.be_admin.common.exception.ErrorMessage;
import site.cleanfree.be_admin.common.exception.ErrorStatus;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final AdminRepository adminRepository;

    @Bean
    public UserDetailsService memberDetailsService() {
        return uuid -> adminRepository.findByAdminUuid(uuid)
                .map(admin -> new User(
                        admin.getAdminUuid(),
                        "",
                        new ArrayList<>()
                ))
                .orElseThrow(
                        //todo 해당 정보는 없을 때 예외 필요
                        () -> new CustomException(ErrorStatus.INCORRECT_ID, ErrorMessage.ID_NOT_EXISTED));
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(memberDetailsService());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
