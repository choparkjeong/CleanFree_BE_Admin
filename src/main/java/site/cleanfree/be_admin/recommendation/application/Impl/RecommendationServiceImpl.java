package site.cleanfree.be_admin.recommendation.application.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.cleanfree.be_admin.common.BaseResponse;
import site.cleanfree.be_admin.common.exception.CustomException;
import site.cleanfree.be_admin.common.exception.ErrorMessage;
import site.cleanfree.be_admin.common.exception.ErrorStatus;
import site.cleanfree.be_admin.recommendation.application.RecommendationService;
import site.cleanfree.be_admin.recommendation.data.dto.ResultResponseDto;
import site.cleanfree.be_admin.recommendation.data.vo.RecommendRequestVo;
import site.cleanfree.be_admin.recommendation.domain.Recommendation;
import site.cleanfree.be_admin.recommendation.infrastructure.RecommendationRepository;

import java.time.LocalDateTime;


@Slf4j
@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {
    private final MongoTemplate mongoTemplate;
    private final RecommendationRepository recommendationRepository;

    @Override
    @Transactional
    public void recommend(String id, RecommendRequestVo recommendRequestVo) {
        Query query = new Query(Criteria.where("resultId").is(id));
        Update update = new Update()
                .set("updatedAt", LocalDateTime.now())
                .set("cosmetics", recommendRequestVo.getCosmeticList())
                .set("ingredients", recommendRequestVo.getIngredients())
                .set("references", recommendRequestVo.getReferences())
                .set("isAnalyze", true)
                ;

        try {
            mongoTemplate.updateFirst(query, update, Recommendation.class);
        } catch(Exception e) {
            log.error("Failed to update document with id: {}", id, e);
            throw new CustomException(ErrorStatus.INCORRECT_ID, ErrorMessage.ID_NOT_EXISTED);
        }
    }

    public BaseResponse<ResultResponseDto> getResult(String authorization, String resultId) {
        Recommendation recommendationResult = getRecommendationByResultId(resultId);

        if (recommendationResult == null) {
            log.info("resultId not exist");
            return BaseResponse.<ResultResponseDto>builder()
                    .success(true)
                    .errorCode(ErrorStatus.NOT_EXISTED_ERROR.getCode())
                    .message("resultId not exist")
                    .data(null)
                    .build();
        }
        log.info("resultId exist");
        return BaseResponse.<ResultResponseDto>builder()
                .success(true)
                .errorCode(null)
                .message("recommendation result find success")
                .data(
                        ResultResponseDto.builder()
                                .resultId(recommendationResult.getResultId())
                                .memberUuid(recommendationResult.getMemberUuid())
                                .question(recommendationResult.getQuestion())
                                .cosmetics(recommendationResult.getCosmetics())
                                .ingredients(recommendationResult.getIngredients())
                                .references(recommendationResult.getReferences())
                                .isAnalyze(recommendationResult.getIsAnalyze())
                                .build()
                )
                .build();
    }

    private Recommendation getRecommendationByResultId(String resultId) {
        return recommendationRepository.getRecommendationByResultId(resultId).orElse(null);
    }
}
