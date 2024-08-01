package site.cleanfree.be_admin.common;

import lombok.Builder;
import lombok.Getter;
import site.cleanfree.be_admin.common.exception.ErrorMessage;
import site.cleanfree.be_admin.common.exception.ErrorStatus;

@Getter
public class BaseResponse<T> {

    private final boolean success;
    private final int errorCode;
    private final String message;
    private final T data;

    @Builder
    public BaseResponse(boolean success, int errorCode, String message, T data) {
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResponse<T> successResponse(String message, T data) {
        return BaseResponse.<T>builder()
                .success(true)
                .errorCode(ErrorStatus.SUCCESS.getCode())
                .message(message)
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> successResponse(String message) {
        return BaseResponse.<T>builder()
                .success(true)
                .errorCode(ErrorStatus.SUCCESS.getCode())
                .message(message)
                .data(null)
                .build();
    }

    public static <T> BaseResponse<T> failResponse(ErrorMessage errorMessage, ErrorStatus errorStatus) {
        return BaseResponse.<T>builder()
                .success(false)
                .errorCode(errorStatus.getCode())
                .message(errorMessage.getMessage())
                .data(null)
                .build();
    }
}
