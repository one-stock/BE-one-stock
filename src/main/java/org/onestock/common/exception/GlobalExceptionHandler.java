package org.onestock.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<?> handleException(BusinessException e) {
        log.info("BusinessException: ", e);
        var errorResponse = ErrorResponse.builder()
                .errorCode(e.getErrorCode())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(e.getErrorCode()).body(errorResponse);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.info("ArgumentNotValidException: ", e);
        var errorResponse = ErrorResponse.builder()
                .errorCode(e.getErrorCode())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(e.getErrorCode()).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("Unhandled Exception: ", e);
        var errorResponse = ErrorResponse.builder()
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("서버 오류가 발생했습니다.")
                .build();
        return ResponseEntity.status(errorResponse.getErrorCode()).body(errorResponse);
    }
}
