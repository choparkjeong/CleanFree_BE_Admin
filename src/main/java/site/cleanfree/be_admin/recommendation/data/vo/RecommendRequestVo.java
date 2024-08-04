package site.cleanfree.be_admin.recommendation.data.vo;

import lombok.Getter;
import site.cleanfree.be_admin.recommendation.domain.Cosmetic;
import site.cleanfree.be_admin.recommendation.domain.Reference;

import java.util.List;

@Getter
public class RecommendRequestVo {

    private String answer;
    private List<Cosmetic> cosmeticList;
    private List<String> ingredients;
    private Reference references;
}
