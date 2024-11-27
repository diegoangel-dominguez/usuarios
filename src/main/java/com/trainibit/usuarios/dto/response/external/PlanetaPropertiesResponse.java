package com.trainibit.usuarios.dto.response.external;

import lombok.Data;

@Data
public class PlanetaPropertiesResponse {
    private String diameter;
    private String rotation_period;
    private String orbital_period;
    private String gravity;
    private String population;
    private String climate;
    private String terrain;
    private String surface_water;
    private String created;
    private String edited;
    private String name;
    private String url;
}
