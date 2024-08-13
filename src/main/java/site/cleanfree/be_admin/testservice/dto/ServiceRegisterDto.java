package site.cleanfree.be_admin.testservice.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ServiceRegisterDto {

    private String service;
    private List<RegisterDto> registrations;
}
