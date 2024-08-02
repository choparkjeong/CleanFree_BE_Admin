package site.cleanfree.be_admin.recommendation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import site.cleanfree.be_admin.recommendation.domain.Cosmetic;
import site.cleanfree.be_admin.recommendation.domain.Reference;

import java.util.List;

@Getter
@Setter
@Builder
public class ResultResponseDto {

    private String resultId;
    private String memberUuid;
    private String question;
    private List<Cosmetic> cosmetics;
    private List<String> ingredients;
    private Reference references;
    private boolean isAnalyze;

    public boolean getIsAnalyze() {
        return this.isAnalyze;
    }

    public void setIsAnalyze(boolean isAnalyze) {
        this.isAnalyze = isAnalyze;
    }
}
