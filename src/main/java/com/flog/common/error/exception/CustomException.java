package com.flog.common.error.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    public CustomException(String errorMessage) {
        super(errorMessage);
    }
}
