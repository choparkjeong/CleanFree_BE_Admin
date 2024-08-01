package site.cleanfree.be_admin.recommendation.application;


import site.cleanfree.be_admin.common.BaseResponse;
import site.cleanfree.be_admin.recommendation.data.vo.RecommendRequestVo;

public interface RecommendationService {

    BaseResponse<?> recommend(String id, RecommendRequestVo recommendRequestVo);
}
