package site.cleanfree.be_admin.recommendation.application.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.cleanfree.be_admin.common.BaseResponse;
import site.cleanfree.be_admin.recommendation.application.RecommendationService;
import site.cleanfree.be_admin.recommendation.data.vo.RecommendRequestVo;
import site.cleanfree.be_admin.recommendation.infrastructure.RecommendationRepository;
import site.cleanfree.be_admin.security.JwtTokenProvider;


@Slf4j
@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public BaseResponse<?> recommend(String id, RecommendRequestVo recommendRequestVo) {
        return null;
    }
}
