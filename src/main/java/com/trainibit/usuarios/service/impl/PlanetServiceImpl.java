package com.trainibit.usuarios.service.impl;

import com.trainibit.usuarios.dto.response.external.PlanetaResponse;
import com.trainibit.usuarios.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanetServiceImpl implements PlanetService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PlanetaResponse getPlanetById(Integer id) {
        String url = "https://www.swapi.tech/api/planets/" + id;
        return restTemplate.getForObject(url, PlanetaResponse.class);

    }
}
