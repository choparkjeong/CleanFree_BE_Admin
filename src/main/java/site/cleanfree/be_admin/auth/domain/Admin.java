package site.cleanfree.be_admin.auth.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.cleanfree.be_admin.common.BaseCreateTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin extends BaseCreateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "admin_id", nullable = false)
    private String adminId;

    @Column(name = "admin_pw", nullable = false)
    private String adminPw;

//    @Column(name = "admin_uuid", nullable = false)
//    private String adminUuid;

    @Builder
    public Admin(String adminId, String adminPw) {
        this.adminId = adminId;
        this.adminPw = adminPw;
//        this.adminUuid = adminUuid;
    }
}
