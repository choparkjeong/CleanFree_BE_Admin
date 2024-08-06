package site.cleanfree.be_admin.recommendation.data.vo;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import site.cleanfree.be_admin.recommendation.domain.Solution;

@Getter
@Builder
public class GetRecommendationResponseVo {
    private String memberUuid;
    private String resultId;
    private String question;
    private List<String> ingredients;
    private List<Solution> solutions;
    private boolean isAnalyze;
}
