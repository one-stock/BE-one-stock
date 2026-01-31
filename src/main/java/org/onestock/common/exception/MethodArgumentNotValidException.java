package org.onestock.common.exception;

import lombok.Getter;

@Getter
public class MethodArgumentNotValidException extends RuntimeException {

    private int errorCode;

    public MethodArgumentNotValidException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
