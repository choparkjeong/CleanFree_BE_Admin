package site.cleanfree.be_admin.testservice.domain;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "cozy_quick")
public class Cozyquick {

    @Id
    private String id;
    @Indexed(unique = true)
    private String ip;
    private String search;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Cozyquick(String id, String ip, String search) {
        this.id = id;
        this.ip = ip;
        this.search = search;
    }
}
