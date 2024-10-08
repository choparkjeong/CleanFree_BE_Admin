package site.cleanfree.be_admin.recommendation.domain;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import site.cleanfree.be_admin.common.MongoBaseTimeEntity;

import java.util.List;

@NoArgsConstructor
@Getter
@ToString
@Document(collection = "recommendation_service")
public class Recommendation extends MongoBaseTimeEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String resultId;
    private String memberUuid;
    private String question;
    private String answer;
    private List<Cosmetic> cosmetics;
    private List<String> ingredients;
    private List<Solution> solutions;
    private Reference references;
    private boolean isAnalyze;

    public boolean getIsAnalyze() {
        return this.isAnalyze;
    }

    @Builder
    public Recommendation(
        String id,
        String resultId,
        String memberUuid,
        String question,
        String answer,
        List<Cosmetic> cosmetics,
        List<String> ingredients,
        List<Solution> solutions,
        Reference references,
        boolean isAnalyze
    ) {
        this.id = id;
        this.resultId = resultId;
        this.memberUuid = memberUuid;
        this.question = question;
        this.answer = answer;
        this.cosmetics = cosmetics;
        this.ingredients = ingredients;
        this.solutions = solutions;
        this.references = references;
        this.isAnalyze = isAnalyze;
    }
}
