package io.github.mlmatheus.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorException extends RuntimeException {

    private String msg;
}
