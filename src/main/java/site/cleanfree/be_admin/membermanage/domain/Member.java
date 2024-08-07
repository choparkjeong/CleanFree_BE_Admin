package site.cleanfree.be_admin.membermanage.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "gender", nullable = false, length = 20)
    private String gender;
    @Column(name = "uuid", nullable = false, length = 10)
    private String uuid;
    @Column(name = "birth_date", nullable = false)
    private String birthDate;
    @Column(name = "day_access_count")
    private Integer dayAccessCount;
    @Column(name = "search_count", nullable = false)
    private int searchCount;
    @Column(name = "total_search_count", nullable = false)
    private int totalSearchCount;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
