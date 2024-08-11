package site.cleanfree.be_admin.testservice.domain;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "consultant_access")
public class ConsultantAccess {

    @Id
    private String id;
    @Indexed(unique = true)
    private String ip;
    private int count;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public ConsultantAccess(String id, String ip, int count) {
        this.id = id;
        this.ip = ip;
        this.count = count;
    }
}
