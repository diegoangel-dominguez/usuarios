package com.trainibit.usuarios.dto.response.external;

import lombok.Data;

import java.io.Serializable;

@Data
public class PlanetaResponse implements Serializable {
    private String message;
    private PlanetaResultResponse result;
}
