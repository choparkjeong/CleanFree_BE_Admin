package site.cleanfree.be_admin.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    ID_NOT_EXISTED("ID가 없습니다."),
    INCORRECT_PASSWORD("비밀번호가 일치하지 않습니다."),
    DUPLICATE_ID("동일 ID가 있습니다.")
    ;

    private final String message;
}
