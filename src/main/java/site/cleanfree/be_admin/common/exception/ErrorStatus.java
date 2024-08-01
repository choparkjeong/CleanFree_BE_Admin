package site.cleanfree.be_admin.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorStatus {
    JWT_ERROR(1001),
    DATA_PERSIST_ERROR(1002),
    DUPLICATED_CATEGORY_ERROR(1003),
    NOT_EXISTED_ERROR(1004),
    INCORRECT_SKIN_STATUS(1005),
    DATA_UPDATE_ERROR(1006),
    BAD_DATA(1007),
    TOKEN_DECODING_ERROR(1008),
    TOKEN_PARSING_ERROR(1009),
    ALREADY_EXIST_DIARY(1010),
    INCORRECT_ID(1011),
    INCORRECT_PW(1012),
    DUPLICATE_ID(1013)
    ;

    private final int code;
}
