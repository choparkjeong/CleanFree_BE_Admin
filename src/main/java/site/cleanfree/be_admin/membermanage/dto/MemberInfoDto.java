package site.cleanfree.be_admin.membermanage.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberInfoDto {

    private String name;
    private String email;
    private String gender;
    private String birthDate;
    private int totalSearchCount;
    private int dayAccessCount;
    private String firstSearchTime;
    private String lastSearchTime;
}
