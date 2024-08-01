package site.cleanfree.be_admin.recommendation.presentation;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.cleanfree.be_admin.common.BaseResponse;
import site.cleanfree.be_admin.recommendation.application.RecommendationService;
import site.cleanfree.be_admin.recommendation.data.vo.RecommendRequestVo;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "맞춤 화장품 답변 API", description = "맞춤 화장품 답변 API")
@RequestMapping("/api/v1/recommend")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/{id}")
    public ResponseEntity<BaseResponse<?>> recommend(
        @RequestHeader String Authorization,
        @PathVariable String id,
        @RequestBody RecommendRequestVo recommendRequestVo
    ) {
        recommendationService.recommend(id, recommendRequestVo);
        return ResponseEntity.ok()
                .body(BaseResponse.successResponse("Recommend Success"));
    }
}
