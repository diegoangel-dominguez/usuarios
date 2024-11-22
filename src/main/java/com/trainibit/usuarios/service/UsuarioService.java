package com.trainibit.usuarios.service;

import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.response.UsuarioResponse;

import java.util.List;

public interface UsuarioService {

    //Definir comportamientos que alguien mas va a implementar


    //Lista de Usuarios
    List<UsuarioResponse> findAll();

    //Un solo usuario
    UsuarioResponse findById(Long id);

    //save user
    //Usuario save(Usuario usuario);
    UsuarioResponse save(Usuario usuario);

    //metodo update que realice la lógica para actualizar un usuario en la base de datos.
    //Usuario update(Long id, Usuario deletedUser);

    UsuarioResponse update(Long id, Usuario deletedUser);

    //metodo para manejar la logica de eliminacion. Si el usuario no existe, lanza una excepcion personalizada (como en el caso de la operacion PUT).
    //Usuario delete(Long id);

    UsuarioResponse delete(Long id);

}
