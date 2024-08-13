package site.cleanfree.be_admin.testservice.domain;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "cure_silver_access")
public class CureSilverAccess {

    @Id
    private String id;
    @Indexed(unique = true)
    private String ip;
    private int count;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
