package site.cleanfree.be_admin.testservice.domain;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "visa")
public class Visa {

    @Id
    private String id;
    @Indexed(unique = true)
    private String ip;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Visa(String id, String ip) {
        this.id = id;
        this.ip = ip;
    }
}
