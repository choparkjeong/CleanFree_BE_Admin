//package site.cleanfree.be_admin.recommendation.presentation;
//
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import site.cleanfree.be_admin.common.BaseResponse;
//import site.cleanfree.be_admin.recommendation.application.RecommendationService;
//import site.cleanfree.be_admin.recommendation.data.dto.ResultResponseDto;
//import site.cleanfree.be_admin.recommendation.data.vo.GetRecommendationResponseVo;
//import site.cleanfree.be_admin.recommendation.data.vo.RecommendRequestVo;
//
//import java.util.List;
//
//@RestController
//@Slf4j
//@RequiredArgsConstructor
//@Tag(name = "맞춤 화장품 답변 API", description = "맞춤 화장품 답변 API")
//@RequestMapping("/api/v1/admin/recommend")
//public class RecommendationController {
//
//    private final RecommendationService recommendationService;
//
//    @PostMapping("/{id}")
//    public ResponseEntity<BaseResponse<?>> recommend(
//        @RequestHeader String Authorization,
//        @PathVariable String id,
//        @RequestBody RecommendRequestVo recommendRequestVo
//    ) {
//        recommendationService.recommend(id, recommendRequestVo);
//        return ResponseEntity.ok()
//                .body(BaseResponse.successResponse("Recommend Success"));
//    }
//
//    @GetMapping("/result/{id}")
//    public ResponseEntity<BaseResponse<ResultResponseDto>> getSearchResult(
//            @RequestHeader String Authorization,
//            @PathVariable String id
//    ) {
//        return ResponseEntity.ok(recommendationService.getResult(Authorization, id));
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<BaseResponse<List<GetRecommendationResponseVo>>> getRecommendation(
//            @RequestHeader String Authorization
//    ) {
//        return ResponseEntity.ok()
//                .body(BaseResponse.successResponse(
//                        "Recommendation Search Success", recommendationService.getRecommendation()));
//    }
//}
