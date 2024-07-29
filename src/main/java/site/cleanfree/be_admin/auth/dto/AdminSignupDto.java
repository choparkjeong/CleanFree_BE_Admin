package site.cleanfree.be_admin.auth.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AdminSignupDto {
    private String id;
    private String pw;
    private String adminUuid;
}
