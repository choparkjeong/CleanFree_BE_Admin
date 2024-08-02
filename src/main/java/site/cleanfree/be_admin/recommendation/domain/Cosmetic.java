package site.cleanfree.be_admin.recommendation.domain;

import lombok.Getter;

@Getter
public class Cosmetic {

    private String cosmetic;
    private String image;
    private String costRange;
    private String url;
    private Review maxReview;
    private Review minReview;

}
