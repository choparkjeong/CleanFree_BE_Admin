package site.cleanfree.be_admin.recommendation.application;


import site.cleanfree.be_admin.common.BaseResponse;
import site.cleanfree.be_admin.recommendation.data.dto.ResultResponseDto;
import site.cleanfree.be_admin.recommendation.data.vo.QuestionVo;
import site.cleanfree.be_admin.recommendation.data.vo.RecommendRequestVo;

public interface RecommendationService {

    void recommend(String id, RecommendRequestVo recommendRequestVo);

    BaseResponse<?> search(String authorization, QuestionVo questionVo);

    BaseResponse<ResultResponseDto> getResult(String authorization, String id);
}
