package site.cleanfree.be_admin.auth.data.vo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AdminSignupRequestVo {
    private String id;
    private String pw;
}
