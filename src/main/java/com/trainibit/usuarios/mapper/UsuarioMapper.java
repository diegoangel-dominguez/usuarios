package com.trainibit.usuarios.mapper;

import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.response.UsuarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = DateUtils.class)
public interface UsuarioMapper {
    @Mapping(target = "edad", expression = "java(usuario.getBirth_day() != null ? DateUtils.calculateAge(usuario.getBirth_day()) : 0)")
    UsuarioResponse mapEntityToDto(Usuario usuario);
}
