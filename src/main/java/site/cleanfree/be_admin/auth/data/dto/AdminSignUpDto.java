package site.cleanfree.be_admin.auth.data.dto;

import lombok.*;

@Builder
@ToString
public class AdminSignUpDto {
    private String id;
    private String pw;
    private String adminUuid;
}
