package site.cleanfree.be_admin.auth.data.vo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AdminSignUpRequestVo {
    private String id;
    private String pw;
}
