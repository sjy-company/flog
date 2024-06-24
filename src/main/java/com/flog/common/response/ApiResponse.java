package com.flog.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean isSuccess;
    private String message;
    private T data;

    public static <T> ApiResponse<T> isSuccess(T data) {
        return new ApiResponse<>(true,"SUCCESS", data);
    }

    public static <T> ApiResponse<T> isError(String message) {
        return new ApiResponse<>(false, message, null);
    }
}
