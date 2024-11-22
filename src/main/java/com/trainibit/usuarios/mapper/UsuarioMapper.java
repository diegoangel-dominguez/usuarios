package com.trainibit.usuarios.mapper;

import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.request.UsuarioRequest;
import com.trainibit.usuarios.response.UsuarioResponse;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public static UsuarioResponse mapEntityToDto(Usuario usuario) {
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setId(usuario.getId());
        usuarioResponse.setName(usuario.getName());
        usuarioResponse.setLastName(usuario.getLastName());
        usuarioResponse.setEmail(usuario.getEmail());
        usuarioResponse.setPassword(usuario.getPassword());
        usuarioResponse.setBirth_day(usuario.getBirth_day());

        if (usuario.getBirth_day() != null) {
            usuarioResponse.setEdad(calculateAge(usuario.getBirth_day()));
        } else {
            usuarioResponse.setEdad(0);
        }

        return usuarioResponse;

    }

    private static int calculateAge(LocalDate birthDate) {

        //Period.between para calcular los años completos entre la fecha de nacimiento (birthDate) y la fecha actual (LocalDate.now()).
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static List<UsuarioResponse> mapListEntityToListDto(List<Usuario> usuarios) {
        List<UsuarioResponse> usuarioResponses = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioResponses.add(mapEntityToDto(usuario));
        }
        return usuarioResponses;
    }


    // Convierte de UsuarioRequest a Usuario
    public static Usuario mapDtoToEntity(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setName(usuarioRequest.getName());
        usuario.setLastName(usuarioRequest.getLastName());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setPassword(usuarioRequest.getPassword());
        usuario.setBirth_day(usuarioRequest.getBirth_day());
        return usuario;
    }

}
