package site.cleanfree.be_admin.testservice.domain;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "create_easy_access")
public class CreateEasyAccess {

    @Id
    private String id;
    @Indexed(unique = true)
    private String ip;
    private int count;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public CreateEasyAccess(String id, String ip) {
        this.id = id;
        this.ip = ip;
    }
}
