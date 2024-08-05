package site.cleanfree.be_admin.recommendation.data.vo;

import lombok.Getter;
import site.cleanfree.be_admin.recommendation.domain.Cosmetic;
import site.cleanfree.be_admin.recommendation.domain.Reference;

import java.util.List;
import site.cleanfree.be_admin.recommendation.domain.Solution;

@Getter
public class RecommendRequestVo {

    private String answer;
    private List<Cosmetic> cosmeticList;
    private List<String> ingredients;
    private List<Solution> solutions;
    private Reference references;
}
