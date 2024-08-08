package site.cleanfree.be_admin.membermanage.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import site.cleanfree.be_admin.common.TimeConvertor;

@Getter
@Setter
public class FirstAndLastQuestionTime {

    private String memberUuid;
    private String name;
    private String email;
    private String gender;
    private String birthDate;
    private int totalSearchCount;
    private int dayAccessCount;
    private LocalDateTime firstSearchTime;
    private LocalDateTime lastSearchTime;

    public void convertKst() {
        this.firstSearchTime = TimeConvertor.utcToKst(firstSearchTime);
        this.lastSearchTime = TimeConvertor.utcToKst(lastSearchTime);
    }
}
