package com.github.diegolins10.clientapi.api.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult<T> {

    private final boolean success;
    private final T data;
    private final String error;

    private RestResult(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public static <T> RestResult<T> ok(T data) {
        return new RestResult<>(true, data, null);
    }

    public static <T> RestResult<T> error(String error) {
        return new RestResult<>(false, null, error);
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }
}
