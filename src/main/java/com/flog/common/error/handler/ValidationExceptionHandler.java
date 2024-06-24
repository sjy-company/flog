package com.flog.common.error.handler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flog.common.response.ApiResponse;

@ControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    ApiResponse<?> handleValidationException(MethodArgumentNotValidException e) {
        return ApiResponse.isError(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
