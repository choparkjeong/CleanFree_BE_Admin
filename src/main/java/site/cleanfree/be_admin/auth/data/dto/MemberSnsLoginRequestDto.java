package site.cleanfree.be_admin.auth.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberSnsLoginRequestDto {

    private String snsId;
//    private String snsType;
//    private String email;
//    private String name;
//    private String sex;
//    private String phoneNumber;
    private String uuid;

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
