package site.cleanfree.be_admin.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
public abstract class MongoBaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdAt;
}
