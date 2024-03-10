package io.github.mlmatheus.exception.handler;

import io.github.mlmatheus.dto.ErrorResponse;
import io.github.mlmatheus.exception.ErrorException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustonExceptionHandler {

    @ExceptionHandler(ErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> internalServerError(HttpServletRequest request, Exception exception) {
        return new ResponseEntity<>(buildError(request, exception.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorResponse buildError(HttpServletRequest request, String message, Integer httpStatus) {
        return ErrorResponse.builder()
                .path(request.getServletPath())
                .errorMessage(message)
                .httpStatus(httpStatus)
                .build();
    }
}
