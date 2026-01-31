package org.onestock.common.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private final int errorCode;
    private final String message;

    @Builder
    public ErrorResponse(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
