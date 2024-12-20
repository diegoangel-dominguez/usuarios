package com.trainibit.usuarios.response;

import lombok.Data;

@Data
public class ApiErrorResponse {

    private String message;
    private Integer status;

    public ApiErrorResponse(String message, Integer status) {
        this.message = message;
        this.status = status;
    }
}
