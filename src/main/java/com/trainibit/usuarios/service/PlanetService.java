package com.trainibit.usuarios.service;

import com.trainibit.usuarios.dto.response.external.PlanetaResponse;

public interface PlanetService {
    PlanetaResponse getPlanetById(Integer id);
}
