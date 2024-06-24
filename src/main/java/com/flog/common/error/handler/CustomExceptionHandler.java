package com.flog.common.error.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flog.common.error.exception.CustomException;
import com.flog.common.response.ApiResponse;

@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(CustomException.class)
	@ResponseBody
	ApiResponse<?> handleCustomException(CustomException e) {
		return ApiResponse.isError(e.getMessage());
	}
}
