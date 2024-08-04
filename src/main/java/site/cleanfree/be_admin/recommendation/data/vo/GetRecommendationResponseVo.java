package site.cleanfree.be_admin.recommendation.data.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetRecommendationResponseVo {
    private String memberUuid;
    private String resultId;
    private String question;
    private boolean isAnalyze;
}
