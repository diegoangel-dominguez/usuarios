package com.trainibit.usuarios.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UsuarioResponse {

    //private Long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private LocalDate birth_day;

    private int edad;

    private UUID uuid;

    private String planeta;


}
