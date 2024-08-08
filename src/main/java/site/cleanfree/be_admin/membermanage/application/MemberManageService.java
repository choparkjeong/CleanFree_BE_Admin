package site.cleanfree.be_admin.membermanage.application;

import java.util.List;
import org.springframework.stereotype.Service;
import site.cleanfree.be_admin.common.BaseResponse;
import site.cleanfree.be_admin.membermanage.dto.FirstAndLastQuestionTime;

@Service
public interface MemberManageService {

    BaseResponse<List<FirstAndLastQuestionTime>> getMemberInfos();
}
