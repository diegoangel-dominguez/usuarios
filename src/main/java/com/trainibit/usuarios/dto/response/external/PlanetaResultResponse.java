package com.trainibit.usuarios.dto.response.external;

import lombok.Data;

import java.io.Serializable;

@Data
public class PlanetaResultResponse implements Serializable {
    PlanetaPropertiesResponse properties;
    private String description;
    private String _id;
    private String uid;
    private Integer __v;
}
