package site.cleanfree.be_admin.testservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GoogleSheetResponseDto {

    private String service;
    private int registerCount;
    private int accessCount;
}
