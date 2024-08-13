package site.cleanfree.be_admin.testservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterDto {

    private String name;
    private String phoneNumber;
}
