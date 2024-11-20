package com.trainibit.usuarios.service;

import com.trainibit.usuarios.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    //Definir comportamientos que alguien mas va a implementar


    //Lista de Usuarios
    List<Usuario> findAll();

    //Un solo usuario
    Usuario findById(Long id);

    //save user

    Usuario save(Usuario usuario);


}
