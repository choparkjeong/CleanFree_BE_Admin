package site.cleanfree.be_admin.common.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorStatus status;
    private final ErrorMessage errorMessage;

    public CustomException(ErrorStatus status, ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
