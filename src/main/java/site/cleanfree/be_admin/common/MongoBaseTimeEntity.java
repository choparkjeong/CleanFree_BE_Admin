package site.cleanfree.be_admin.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
public abstract class MongoBaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdAt; //todo: mongodb에 적용 안되는 문제 해결하기

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
